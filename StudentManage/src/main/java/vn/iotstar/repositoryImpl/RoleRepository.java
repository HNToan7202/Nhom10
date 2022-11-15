package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Role;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.IRoleRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoleRepository implements IRoleRepository{
    private static RoleRepository instance = null;
    public static RoleRepository getInstance(){
        if(instance == null)
            instance = new RoleRepository();
        return instance;
    }

    private final String tableName = "role";
    @Override
    public boolean insert(Role request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("roleId", request.getRoleId())
                    .withString("roleName", request.getRoleName())
                    .withString("deleted", "0");
            table.putItem(item);

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Role request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "roleName");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getRoleName());

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("roleId", request.getRoleId())
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

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
		/*
		 * if(UserRoleRepository.getInstance().containRole(hashKey)) return false;
		 */
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("roleId", hashKey)
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
    private Role getRoleViewModel(String roleId, String roleName, String deleted){
    	Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        role.setDeleted(Integer.parseInt(deleted));
        return role;
    }
    @Override
    public Role retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("roleId", hashKey, "roleId, roleName, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        return getRoleViewModel(item.getString("roleId"),
                item.getString("roleName"),
                item.getString("deleted"));
    }

    @Override
    public ArrayList<Role> retrieveAll() {
        ArrayList<Role> roles = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("roleId", "roleName", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue roleId = item.getOrDefault("roleId", new AttributeValue());
                AttributeValue roleName = item.getOrDefault("roleName", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
                roles.add(getRoleViewModel(roleId.getS(), roleName.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return roles;
    }
}
