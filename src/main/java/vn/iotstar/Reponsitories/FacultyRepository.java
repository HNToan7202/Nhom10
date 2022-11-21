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

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.Grade;
import vn.iotstar.database.AWSDynamoDB;

@Repository
@EnableScan
public class FacultyRepository {
	private final String tableName = "faculty";

	@Autowired  //Đưa đối tượng
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
        try{
            ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName)
                    .withAttributesToGet("facultyId", "facultyName", "image" , "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue facultyId = item.getOrDefault("facultyId", new AttributeValue());
                AttributeValue facultyName = item.getOrDefault("facultyName", new AttributeValue());
                AttributeValue image = item.getOrDefault("image", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
                faculty.setFacultyId(facultyId.getS());
                faculty.setFacultyName(facultyName.getS());
                faculty.setImage(image.getS());
                faculty.setDeleted(Integer.parseInt(deleted.getN()));
                faculties.add(faculty);
               }

        }catch(Exception e){
            return null;
        }
        return faculties;
	}

	public String deleteFacultyById(String studentId) {
		dynamoDBMapper.delete(dynamoDBMapper.load(Grade.class, studentId));
		return "StudentId : " + studentId + " Deleted!";
	}

	public String updateFaculty(String studentId, Grade grade) {
		dynamoDBMapper.save(grade, new DynamoDBSaveExpression().withExpectedEntry("studentId",
				new ExpectedAttributeValue(new AttributeValue().withS(studentId))));
		return studentId;
	}
}
