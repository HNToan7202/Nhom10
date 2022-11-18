package vn.iotstar.Reponsitories;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Grade;
import vn.iotstar.database.AWSDynamoDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@Repository
 @EnableScan 
public class GradeRepository {
	private final String tableName = "grade";
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	public Grade saveGrade(Grade grade) {
        dynamoDBMapper.save(grade);
        return grade;
    }

    public Grade getStudentId(String studentId) {
        return dynamoDBMapper.load(Grade.class, studentId);
    }
    public List<Grade> findAll(){
    	 List<Grade> grades = new ArrayList<>();
    	 Grade grade = new Grade();
         try{
             ScanRequest scanRequest = new ScanRequest()
                     .withTableName(tableName)
                     .withAttributesToGet("studentId", "subjectGroupId","middleGrade", "finalGrade","totalGrade", "deleted");

             ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
             for (Map<String, AttributeValue> item : result.getItems()){
                 AttributeValue studentId = item.getOrDefault("studentId", new AttributeValue());
                 AttributeValue subjectId = item.getOrDefault("subjectGroupId", new AttributeValue());
                 AttributeValue gradep = item.getOrDefault("Grade", new AttributeValue());
                 grade.setStudentId(studentId.getS());
                 grade.setSubjectId(subjectId.getS());
                 grade.setGrade(Long.parseLong(gradep.getN()));
                 grades.add(grade);
             }
         }catch(Exception e){
             return null;
         }
         return grades;
    }

	public String deleteGradeById(String studentId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Grade.class, studentId));
        return "StudentId : "+ studentId +" Deleted!";
    }

    public String updateGrade(String studentId, Grade grade) {
        dynamoDBMapper.save(grade,
                new DynamoDBSaveExpression()
        .withExpectedEntry("studentId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(studentId)
                )));
        return studentId;
    }
}
