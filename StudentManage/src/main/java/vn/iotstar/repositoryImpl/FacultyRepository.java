package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.database.AWSS3;
import vn.iotstar.repositories.IFacultyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FacultyRepository implements IFacultyRepository{

    private static FacultyRepository instance = null;
    public static FacultyRepository getInstance(){
        if(instance == null)
            instance = new FacultyRepository();
        return instance;
    }
    
    private final String tableName = "faculty";
    
    public boolean insert(Faculty request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("facultyId", request.getFacultyId())
                    .withString("facultyName", request.getFacultyName())
                    .withString("image", AWSS3.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()))
                    .withString("deleted", "0");
            table.putItem(item);

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }


    public boolean update(Faculty request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "facultyName");
            expressionAttributeNames.put("#Q", "image");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getFacultyName());
            expressionAttributeValues.put(":val2", AWSS3.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()));

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("facultyId", request.getFacultyId())
                    .withUpdateExpression("set #P = :val1, #Q = :val2")
                    .withNameMap(expressionAttributeNames)
                    .withValueMap(expressionAttributeValues);

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(String hashKey, String rangeKey) {

        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        if(LectureRepository.getInstance().containLectureBelongFaculty(hashKey) ||
                StudentClassRepository.getInstance().containFaculty(hashKey))
            return false;
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("facultyId", hashKey)
                    .withUpdateExpression("set #P = :val1")
                    .withNameMap(expressionAttributeNames)
                    .withValueMap(expressionAttributeValues);

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    private Faculty getFacultyViewModel(String facultyId, String facultyName, String image, String deleted){
    	Faculty faculty = new Faculty();
        faculty.setFacultyId(facultyId);
        faculty.setFacultyName(facultyName);
        faculty.setDeleted(Integer.parseInt(deleted));
        faculty.setImage(image);
        return faculty;
    }

    public Faculty retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("facultyId", hashKey, "facultyId, facultyName, image, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        return getFacultyViewModel(item.getString("facultyId"),
                item.getString("facultyName"),
                item.getString("image"),
                item.getString("deleted"));
    }

    public ArrayList<Faculty> retrieveAll() {
        ArrayList<Faculty> faculties = new ArrayList<>();
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
                faculties.add(getFacultyViewModel(facultyId.getS(), facultyName.getS(),image.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return faculties;
    }
}
