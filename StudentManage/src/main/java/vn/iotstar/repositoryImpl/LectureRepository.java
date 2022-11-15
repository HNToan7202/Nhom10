package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.User;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.database.AWSS3;
import vn.iotstar.repositories.ILectureRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LectureRepository implements ILectureRepository{
    private static LectureRepository instance = null;
    public static LectureRepository getInstance(){
        if(instance == null)
            instance = new LectureRepository();
        return instance;
    }
    private final String tableName = "lecture";
    @Override
    public boolean insert(Lecture request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("lectureId", request.getLectureId())
                    .withString("facultyId",request.getFacultyId())
                    .withString("lectureName", request.getLectureName())
                    .withString("dob", request.getDob())
                    .withString("address", request.getAddress())
                    .withString("gender",request.getGender())
                    .withString("phone",request.getPhone())
                    .withString("image", AWSS3.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()))
                    .withString("deleted","0");
            table.putItem(item);

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Lecture request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "facultyId");
            expressionAttributeNames.put("#P2", "lectureName");
            expressionAttributeNames.put("#P3", "dob");
            expressionAttributeNames.put("#P4", "address");
            expressionAttributeNames.put("#P5", "gender");
            expressionAttributeNames.put("#P6", "phone");
            expressionAttributeNames.put("#P7", "image");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getFacultyId());
            expressionAttributeValues.put(":val2", request.getLectureName());
            expressionAttributeValues.put(":val3", request.getDob());
            expressionAttributeValues.put(":val4", request.getAddress());
            expressionAttributeValues.put(":val5", request.getGender());
            expressionAttributeValues.put(":val6", request.getPhone());
            expressionAttributeValues.put(":val7", AWSS3.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()));

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("lectureId", request.getLectureId())
                    .withUpdateExpression("set #P1 = :val1, #P2 = :val2, #P3 = :val3, #P4 = :val4, #P5 = :val5, #P6 = :val6, #P7 = :val7")
                    .withNameMap(expressionAttributeNames)
                    .withValueMap(expressionAttributeValues);

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		/*
		 * if(SubjectGroupService.getInstance().containLecture(hashKey)) return false;
		 */
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("lectureId", hashKey)
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
    private Lecture getLectureViewModel(String lectureId, String facultyId, String lectureName,
                                                 String dob, String address, String gender, String phone, String image, String deleted){
    	Lecture lecture = new Lecture();

        lecture.setLectureId(lectureId);
        lecture.setLectureName(lectureName);
        lecture.setFacultyId(facultyId);
        lecture.setAddress(address);
        lecture.setGender(gender);
        lecture.setPhone(phone);
        lecture.setDob(dob);
        lecture.setDeleted(Integer.parseInt(deleted));
        Faculty faculty = FacultyRepository.getInstance().retrieveById(facultyId,"");
        lecture.setFacultyName(faculty.getFacultyName());

        ArrayList<User> users = UserRepository.getInstance().retrieveAll();
        for(User u:users){
            if(Objects.equals(u.getLectureId(), lectureId)){
                lecture.setUsername(u.getUsername());
                lecture.setPassword(u.getPassword());
                break;
            }
        }
        ArrayList<UserRoleViewModel> userRoles = UserRoleRepository.getInstance().retrieveAll();
        ArrayList<String> roleIds = new ArrayList<>();
        for(UserRoleViewModel u:userRoles){
            if(Objects.equals(u.getUsername(), lecture.getUsername())){
                roleIds.add(u.getRoleId());
            }
        }
        lecture.setImage(image);
        lecture.setRoleIds(roleIds);
        return lecture;
    }
    @Override
    public Lecture retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("lectureId", hashKey, "lectureId, facultyId, lectureName, dob, address, gender, phone, image, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        return getLectureViewModel(item.getString("lectureId"),
                item.getString("facultyId"),
                item.getString("lectureName"),
                item.getString("dob"),
                item.getString("address"),
                item.getString("gender"),
                item.getString("phone"),
                item.getString("image"),
                item.getString("deleted"));
    }

    @Override
    public ArrayList<Lecture> retrieveAll() {
        ArrayList<Lecture> lectures = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("lectureId", "facultyId", "lectureName", "dob", "address", "gender", "phone", "image", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){

                AttributeValue lectureId = item.getOrDefault("lectureId", new AttributeValue());
                AttributeValue facultyId = item.getOrDefault("facultyId", new AttributeValue());
                AttributeValue lectureName = item.getOrDefault("lectureName", new AttributeValue());
                AttributeValue dob = item.getOrDefault("dob", new AttributeValue());
                AttributeValue address = item.getOrDefault("address", new AttributeValue());
                AttributeValue gender = item.getOrDefault("gender", new AttributeValue());
                AttributeValue phone = item.getOrDefault("phone", new AttributeValue());
                AttributeValue image = item.getOrDefault("image", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());

                lectures.add(getLectureViewModel(lectureId.getS(), facultyId.getS(), lectureName.getS(), dob.getS()
                        , address.getS(), gender.getS(), phone.getS(), image.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return lectures;
    }

    @Override
    public boolean containLectureBelongFaculty(String facultyId) {
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("lectureId", "facultyId");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue id = item.getOrDefault("facultyId", new AttributeValue());
                if(Objects.equals(id.getS(), facultyId))
                    return true;
            }

        }catch(Exception e){
            return false;
        }
        return false;
    }
}
