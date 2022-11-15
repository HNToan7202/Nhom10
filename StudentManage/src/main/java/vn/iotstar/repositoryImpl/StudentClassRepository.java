package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.StudentClass;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.IStudentClassRepository;
import vn.iotstar.servicesImpl.FacultyServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StudentClassRepository implements IStudentClassRepository {
	private static StudentClassRepository instance = null;

	public static StudentClassRepository getInstance() {
		if (instance == null)
			instance = new StudentClassRepository();
		return instance;
	}

	private final String tableName = "student_class";

	@Override
	public boolean insert(StudentClass request) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		try {

			Item item = new Item().withPrimaryKey("studentClassId", request.getStudentClassId())
					.withString("studentClassName", request.getStudentClassName())
					.withString("facultyId", request.getFacultyId()).withString("deleted", "0");
			table.putItem(item);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean update(StudentClass request) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

		try {
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#P1", "studentClassName");
			expressionAttributeNames.put("#P2", "facultyId");

			Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
			expressionAttributeValues.put(":val1", request.getStudentClassName());
			expressionAttributeValues.put(":val2", request.getFacultyId());

			UpdateItemSpec updateItemSpec = new UpdateItemSpec()
					.withPrimaryKey("studentClassId", request.getStudentClassId())
					.withUpdateExpression("set #P1 = :val1, #P2 = :val2").withNameMap(expressionAttributeNames)
					.withValueMap(expressionAttributeValues);

			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String hashKey, String rangeKey) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		if (StudentRepository.getInstance().containStudentClass(hashKey))
			return false;
		try {
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#P", "deleted");

			Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
			expressionAttributeValues.put(":val1", "1");

			UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("studentClassId", hashKey)
					.withUpdateExpression("set #P = :val1").withNameMap(expressionAttributeNames)
					.withValueMap(expressionAttributeValues);

			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private StudentClass getStudentClassViewModel(String studentClassId, String studentClassName,
			String facultyId, String deleted) {
		StudentClass studentClass = new StudentClass();
		studentClass.setStudentClassId(studentClassId);
		studentClass.setStudentClassName(studentClassName);
		studentClass.setFacultyId(facultyId);
		studentClass.setDeleted(Integer.parseInt(deleted));

		Faculty faculty = FacultyServiceImpl.getInstance().retrieveById(facultyId, "");
		studentClass.setFacultyName(faculty.getFacultyName());
		return studentClass;
	}

	@Override
	public StudentClass retrieveById(String hashKey, String rangeKey) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		Item item = null;
		try {

			item = table.getItem("studentClassId", hashKey, "studentClassId, studentClassName, facultyId, deleted",
					null);

		} catch (Exception e) {
			return null;
		}
		return getStudentClassViewModel(item.getString("studentClassId"), item.getString("studentClassName"),
				item.getString("facultyId"), item.getString("deleted"));
	}

	@Override
	public ArrayList<StudentClass> retrieveAll() {
		ArrayList<StudentClass> studentClasses = new ArrayList<>();
		try {
			ScanRequest scanRequest = new ScanRequest().withTableName(tableName).withAttributesToGet("studentClassId",
					"studentClassName", "facultyId", "deleted");

			ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
				AttributeValue studentClassId = item.getOrDefault("studentClassId", new AttributeValue());
				AttributeValue studentClassName = item.getOrDefault("studentClassName", new AttributeValue());
				AttributeValue facultyId = item.getOrDefault("facultyId", new AttributeValue());
				AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
				studentClasses.add(getStudentClassViewModel(studentClassId.getS(), studentClassName.getS(),
						facultyId.getS(), deleted.getS()));
			}

		} catch (Exception e) {
			return null;
		}
		return studentClasses;
	}

	@Override
	public boolean containFaculty(String facultyId) {
		try {
			ScanRequest scanRequest = new ScanRequest().withTableName(tableName).withAttributesToGet("facultyId");

			ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
				AttributeValue id = item.getOrDefault("facultyId", new AttributeValue());
				if (Objects.equals(id.getS(), facultyId))
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
