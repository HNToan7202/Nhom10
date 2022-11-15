package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Grade;
import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.Subject;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.IGradeRepository;
import vn.iotstar.services.IGradeService;
import vn.iotstar.servicesImpl.GradeServiceImpl;
import vn.iotstar.servicesImpl.StudentServiceImpl;
import vn.iotstar.servicesImpl.SubjectServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GradeRepository implements IGradeRepository {
	private static GradeRepository instance = null;
	private final String tableName = "grade";

	public static GradeRepository getInstance() {
		if (instance == null)
			instance = new GradeRepository();
		return instance;
	}

	public boolean insert(Grade request) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		try {

			Item item = new Item()
					.withPrimaryKey("studentId", request.getStudentId(), "subjectGroupId", request.getSubjectId())
					.withDouble("middleGrade", request.getMiddleGrade())
					.withDouble("finalGrade", request.getFinalGrade()).withDouble("totalGrade", request.getTotalGrade())
					.withString("deleted", "0");
			table.putItem(item);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean update(Grade request) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

		try {
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#P", "middleGrade");
			expressionAttributeNames.put("#Q", "finalGrade");
			expressionAttributeNames.put("#R", "totalGrade");

			Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
			expressionAttributeValues.put(":val1", request.getMiddleGrade());
			expressionAttributeValues.put(":val2", request.getFinalGrade());
			expressionAttributeValues.put(":val3", request.getTotalGrade());

			UpdateItemSpec updateItemSpec = new UpdateItemSpec()
					.withPrimaryKey("studentId", request.getStudentId(), "subjectGroupId", request.getSubjectId())
					.withUpdateExpression("set #P = :val1, #Q = :val2, #R = :val3")
					.withNameMap(expressionAttributeNames).withValueMap(expressionAttributeValues);

			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean delete(String hashKey, String rangeKey) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

		try {
			Map<String, String> expressionAttributeNames = new HashMap<String, String>();
			expressionAttributeNames.put("#P", "deleted");

			Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
			expressionAttributeValues.put(":val1", "1");

			UpdateItemSpec updateItemSpec = new UpdateItemSpec()
					.withPrimaryKey("studentId", hashKey, "subjectGroupId", rangeKey)
					.withUpdateExpression("set #P = :val1").withNameMap(expressionAttributeNames)
					.withValueMap(expressionAttributeValues);

			UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private Grade getGrade(String studentId, String subjectGroupId, double middleGrade, double finalGrade,
			double totalGrade, String deleted) {
		Grade grade = new Grade();
		grade.setStudentId(studentId);
		grade.setSubjectId(subjectGroupId);
		grade.setMiddleGrade(middleGrade);
		grade.setFinalGrade(finalGrade);
		grade.setDeleted(Integer.parseInt(deleted));
		grade.setTotalGrade(totalGrade);
		Student student = StudentServiceImpl.getInstance().retrieveById(studentId, "");
		grade.setStudentId(student.getStudentName());

		//
		//Subject group
		Subject subjectGroup = SubjectServiceImpl.getInstance().retrieveById(subjectGroupId, "");
		grade.setSubjectId(subjectGroup.getSubjectId());
		return grade;
	}
	// Get Grade View 
	public Grade retrieveById(String hashKey, String rangeKey) {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		Item item = null;
		try {
			item = table.getItem("studentId", hashKey, "subjectGroupId", rangeKey,
					"studentId, subjectGroupId, middleGrade, finalGrade, totalGrade, deleted", null);

		} catch (Exception e) {
			return null;
		}
		return getGrade(item.getString("studentId"), item.getString("subjectGroupId"),
				item.getDouble("middleGrade"), item.getDouble("finalGrade"), item.getDouble("totalGrade"),
				item.getString("deleted"));
	}

	public ArrayList<Grade> retrieveAll() {
		ArrayList<Grade> grades = new ArrayList<>();
		try {
			ScanRequest scanRequest = new ScanRequest().withTableName(tableName).withAttributesToGet("studentId",
					"subjectGroupId", "middleGrade", "finalGrade", "totalGrade", "deleted");

			ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
				AttributeValue studentId = item.getOrDefault("studentId", new AttributeValue());
				AttributeValue subjectGroupId = item.getOrDefault("subjectGroupId", new AttributeValue());
				AttributeValue middleGrade = item.getOrDefault("middleGrade", new AttributeValue());
				AttributeValue finalGrade = item.getOrDefault("finalGrade", new AttributeValue());
				AttributeValue totalGrade = item.getOrDefault("totalGrade", new AttributeValue());
				AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
				grades.add(getGrade(studentId.getS(), subjectGroupId.getS(),
						Double.parseDouble(middleGrade.getN()), Double.parseDouble(finalGrade.getN()),
						Double.parseDouble(totalGrade.getN()), deleted.getS()));
			}

		} catch (Exception e) {
			return null;
		}
		return grades;
	}

	private boolean contain(String hashKey) {
		try {
			ScanRequest scanRequest = new ScanRequest().withTableName(tableName).withAttributesToGet(hashKey);

			ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
				AttributeValue id = item.getOrDefault(hashKey, new AttributeValue());
				if (Objects.equals(id.getS(), hashKey))
					return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean containStudent(String studentId) {
		return contain(studentId);
	}

	public boolean containSubjectGroup(String subjectGroupId) {
		return contain(subjectGroupId);
	}

	@Override
	public ArrayList<Grade> retrieveGradeByLectureId(String lectureId) {
		ArrayList<SubjectGroupViewModel> subjectGroups = SubjectGroupService.getInstance().retrieveAll();
		subjectGroups.removeIf(x -> !Objects.equals(x.getLectureId(), lectureId));
		ArrayList<Grade> grades = GradeServiceImpl.getInstance().retrieveAll();
		subjectGroups.forEach(x -> grades.removeIf(g -> !Objects.equals(g.getSubjectGroupId(), x.getSubjectGroupId())));

		return grades;
	}
}
