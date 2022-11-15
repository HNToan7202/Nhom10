package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.StudentClass;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.database.AWSS3;
import vn.iotstar.repositories.IStudentRepository;
import vn.iotstar.servicesImpl.GradeServiceImpl;
import vn.iotstar.servicesImpl.StudentClassServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StudentRepository implements IStudentRepository{
    private static StudentRepository instance = null;
    public static StudentRepository getInstance(){
        if(instance == null)
            instance = new StudentRepository();
        return instance;
    }
    private final String tableName = "student";
    @Override
    public boolean insert(Student request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("studentId", request.getStudentId())
                    .withString("studentClassId",request.getStudentClassId())
                    .withString("studentName", request.getStudentName())
                    .withString("birthday", request.getBirthday())
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
    public boolean update(Student request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "studentClassId");
            expressionAttributeNames.put("#P2", "studentName");
            expressionAttributeNames.put("#P3", "dob");
            expressionAttributeNames.put("#P4", "address");
            expressionAttributeNames.put("#P5", "gender");
            expressionAttributeNames.put("#P6", "phone");
            expressionAttributeNames.put("#P7", "image");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getStudentClassId());
            expressionAttributeValues.put(":val2", request.getStudentName());
            expressionAttributeValues.put(":val3", request.getBirthday());
            expressionAttributeValues.put(":val4", request.getAddress());
            expressionAttributeValues.put(":val5", request.getGender());
            expressionAttributeValues.put(":val6", request.getPhone());
            expressionAttributeValues.put(":val7", AWSS3.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()));

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("studentId", request.getStudentId())
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
        if(GradeServiceImpl.getInstance().containStudent(hashKey))
            return false;
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("studentId", hashKey)
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
    private Student getStudentViewModel(String studentId, String studentClassId, String studentName,
                                                 String dob, String address, String gender, String phone, String image, String deleted){
    	Student student = new Student();

        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setStudentClassId(studentClassId);
        student.setAddress(address);
        student.setGender(gender);
        student.setPhone(phone);
        student.setBirthday(dob);
        student.setDeleted(Integer.parseInt(deleted));

        StudentClass studentClass = StudentClassServiceImpl.getInstance().retrieveById(studentClassId, "");
        student.setFacultyName(studentClass.getFacultyName());
        student.setStudentClassName(studentClass.getStudentClassName());
        student.setImage(image);
        return student;
    }
    @Override
    public Student retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("studentId", hashKey, "studentId, studentClassId, studentName, dob, address, gender, phone, image, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        return getStudentViewModel(item.getString("studentId"),
                item.getString("studentClassId"),
                item.getString("studentName"),
                item.getString("dob"),
                item.getString("address"),
                item.getString("gender"),
                item.getString("phone"),
                item.getString("image"),
                item.getString("deleted"));
    }

    @Override
    public ArrayList<Student> retrieveAll() {
        ArrayList<Student> students = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("studentId", "studentClassId", "studentName", "dob", "address", "gender", "phone", "image", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){

                AttributeValue studentId = item.getOrDefault("studentId", new AttributeValue());
                AttributeValue studentClassId = item.getOrDefault("studentClassId", new AttributeValue());
                AttributeValue studentName = item.getOrDefault("studentName", new AttributeValue());
                AttributeValue dob = item.getOrDefault("dob", new AttributeValue());
                AttributeValue address = item.getOrDefault("address", new AttributeValue());
                AttributeValue gender = item.getOrDefault("gender", new AttributeValue());
                AttributeValue phone = item.getOrDefault("phone", new AttributeValue());
                AttributeValue image = item.getOrDefault("image", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());

                students.add(getStudentViewModel(studentId.getS(), studentClassId.getS(), studentName.getS(), dob.getS()
                        , address.getS(), gender.getS(), phone.getS(),image.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return students;
    }

    @Override
    public boolean containStudentClass(String studentClassId) {
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("studentClassId", "studentId");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue id = item.getOrDefault("studentClassId", new AttributeValue());
                if(Objects.equals(id.getS(), studentClassId))
                    return true;
            }

        }catch(Exception e){
            return false;
        }
        return false;
    }
}
