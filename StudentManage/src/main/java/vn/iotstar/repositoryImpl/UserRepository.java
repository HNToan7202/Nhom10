package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.User;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.IUserRepository;
import vn.iotstar.utils.UserUtils;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository implements IUserRepository {
    private static UserRepository instance = null;
    public static UserRepository getInstance(){
        if(instance == null)
            instance = new UserRepository();
        return instance;
    }
    private final String tableName = "user";
    @Override
    public boolean insert(User request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("username", request.getUsername())
                    .withString("password", UserUtils.hashPassword(request.getPassword()))
                    .withString("lectureId", request.getLectureId())
                    .withString("deleted", "0");
            table.putItem(item);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "password");
            expressionAttributeNames.put("#P2", "lectureId");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", UserUtils.hashPassword(request.getPassword()));
            expressionAttributeValues.put(":val2", request.getLectureId());

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("username", request.getUsername())
                    .withUpdateExpression("set #P1 = :val1, #P2 = :val2")
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
		 * if(UserRoleService.getInstance().containUser(hashKey)) return false;
		 */
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("username", hashKey)
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
    private User getUserViewModel(String username, String password, String lectureId, String deleted){
    	User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setLectureId(lectureId);
        user.setDeleted(Integer.parseInt(deleted));

        //LectureViewModel lecture = LectureService.getInstance().retrieveById(lectureId, "");
        //user.setLectureName(lecture.getLectureName());

        return user;
    }
    @Override
    public User retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("username", hashKey, "username, password, lectureId, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        if(item == null)
            return null;
        return getUserViewModel(item.getString("username"),
                item.getString("password"),
                item.getString("lectureId"),
                item.getString("deleted")
                );
    }

    @Override
    public ArrayList<User> retrieveAll() {
        ArrayList<User> users = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("username", "password", "lectureId", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue username = item.getOrDefault("username", new AttributeValue());
                AttributeValue password = item.getOrDefault("password", new AttributeValue());
                AttributeValue lectureId = item.getOrDefault("lectureId", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
                users.add(getUserViewModel(username.getS(), password.getS(), lectureId.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return users;
    }

    @Override
    public boolean login(String username, String password) {
    	User u = null;
        try {
            u = retrieveById(username, "");
        }
        catch(Exception e){
            return false;
        }
        if(u == null)
            return false;
        try {
            return u.getPassword().equals(UserUtils.hashPassword(password));
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
