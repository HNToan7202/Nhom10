package vn.iotstar.repositoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.User;
import vn.iotstar.Entity.UserRole;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.IUserRoleRepository;
import vn.iotstar.utils.UserUtils;

public class UserRoleRepository implements IUserRoleRepository {
    private static UserRepository instance = null;
    public static UserRepository getInstance(){
        if(instance == null)
            instance = new UserRepository();
        return instance;
    }
    private final String tableName = "userrole";

	@Override
	public boolean insert(UserRole request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("username", request.getUserName())
                    .withString("roleId", UserUtils.hashPassword(request.getRoleId()));
            table.putItem(item);
        }
        catch (Exception e) {
            return false;
        }
        return true;
	}

	@Override
	public boolean update(UserRole request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "roleId");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", UserUtils.hashPassword(request.getRoleId()));


            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("username", request.getUserName())
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
    private UserRole getUserRole(String username, String roleId){
    	UserRole userrole = new UserRole();
        userrole.setUserName(username);
        userrole.setRoleId(roleId);

        return userrole;
    }
	

	@Override
	public UserRole retrieveById(String hashKey, String rangeKey) {
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
        return getUserRole(item.getString("username"),
                item.getString("roleId")
                );
	}

	@Override
	public ArrayList<UserRole> retrieveAll() {
        ArrayList<UserRole> userroles = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("username", "password", "lectureId", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue username = item.getOrDefault("username", new AttributeValue());
                AttributeValue password = item.getOrDefault("roleId", new AttributeValue());

                userroles.add(getUserRole(username.getS(), password.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return userroles;
	}

	
	//Chua biet la gi nen chua viet
	@Override
	public boolean containRole(String roleId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
