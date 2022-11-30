package vn.iotstar.Reponsitories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Config.AWSDynamoDB;
import vn.iotstar.Entity.Faculty;
@Repository
@EnableScan
public class FacultyRepository {
	private final String tableName = "faculty";

	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	public Faculty saveFaculty(Faculty faculty) {
		dynamoDBMapper.save(faculty);
		return faculty;
	}

	public Faculty getFacultyId(String facultyId) {
		return dynamoDBMapper.load(Faculty.class, facultyId);
	}

	public List<Faculty> findAll() {
		List<Faculty> faculties = new ArrayList<>();
		Faculty faculty = new Faculty();
		try {
			ScanRequest scanRequest = new ScanRequest()
					.withTableName(tableName)
					.withAttributesToGet("id","name","deleted");

			ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
			for (Map<String, AttributeValue> item : result.getItems()) {
				AttributeValue facultyId = item.getOrDefault("id", new AttributeValue());
				AttributeValue facultyName = item.getOrDefault("name", new AttributeValue());
				AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
				faculty.setId(Integer.parseInt(facultyId.getN()));
				faculty.setName(facultyName.getS());
				faculty.setDeleted(Integer.parseInt(deleted.getN()));
				faculties.add(faculty);
			}

		} catch (Exception e) {
			return null;
		}
		return faculties;
	}

	public String deleteFacultyById(String facultyId) {
		dynamoDBMapper.delete(dynamoDBMapper.load(Faculty.class, facultyId));
		return "StudentId : " + facultyId + " Deleted!";
	}

	public String updateFaculty(String facultyId, Faculty faculty) {
		dynamoDBMapper.save(faculty, new DynamoDBSaveExpression().withExpectedEntry("id",
				new ExpectedAttributeValue(new AttributeValue().withS(facultyId))));
		return facultyId;
	}
}
