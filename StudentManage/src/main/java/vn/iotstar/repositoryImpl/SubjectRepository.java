package vn.iotstar.repositoryImpl;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import vn.iotstar.Entity.Subject;
import vn.iotstar.database.AWSDynamoDB;
import vn.iotstar.repositories.ISubjectRepository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubjectRepository implements ISubjectRepository{
    private static SubjectRepository instance = null;
    public static SubjectRepository getInstance(){
        if(instance == null)
            instance = new SubjectRepository();
        return instance;
    }
    private final String tableName = "subject";
    @Override
    public boolean insert(Subject request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        try {

            Item item = new Item().withPrimaryKey("subjectId", request.getSubjectId())
                    .withString("subjectName", request.getSubjectName())
                    .withString("creditsNo", String.valueOf(request.getCreditsNo()))
                    .withString("periodsNo", String.valueOf(request.getPeriodsNo()))
                    .withString("deleted", "0");
            table.putItem(item);

        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Subject request) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);

        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "subjectName");
            expressionAttributeNames.put("#P2", "creditsNo");
            expressionAttributeNames.put("#P3", "periodsNo");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getSubjectName());
            expressionAttributeValues.put(":val2", String.valueOf(request.getCreditsNo()));
            expressionAttributeValues.put(":val3", String.valueOf(request.getPeriodsNo()));

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("subjectId", request.getSubjectId())
                    .withUpdateExpression("set #P1 = :val1, #P2 = :val2, #P3 = :val3")
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
		 * if(SubjectGroupService.getInstance().containSubject(hashKey)) return false;
		 */
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P", "deleted");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", "1");

            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("subjectId", hashKey)
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
    private Subject getSubjectViewModel(String subjectId, String subjectName, String creditsNo, String periodsNo, String deleted){
    	Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        subject.setSubjectName(subjectName);
        subject.setCreditsNo(Integer.parseInt(creditsNo));
        subject.setPeriodsNo(Integer.parseInt(periodsNo));
        subject.setDeleted(Integer.parseInt(deleted));
        return subject;
    }
    @Override
    public Subject retrieveById(String hashKey, String rangeKey) {
        Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable(tableName);
        Item item = null;
        try {

            item = table.getItem("subjectId", hashKey, "subjectId, subjectName, creditsNo, periodsNo, deleted", null);

        }
        catch (Exception e) {
            return null;
        }
        return getSubjectViewModel(item.getString("subjectId"),
                item.getString("subjectName"),
                item.getString("creditsNo"),
                item.getString("periodsNo"),
                item.getString("deleted"));
    }

    @Override
    public ArrayList<Subject> retrieveAll() {
        ArrayList<Subject> subjects = new ArrayList<>();
        try{
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withAttributesToGet("subjectId", "subjectName", "creditsNo", "periodsNo", "deleted");

            ScanResult result = AWSDynamoDB.getInstance().getAmazonClient().scan(scanRequest);
            for (Map<String, AttributeValue> item : result.getItems()){
                AttributeValue subjectId = item.getOrDefault("subjectId", new AttributeValue());
                AttributeValue subjectName = item.getOrDefault("subjectName", new AttributeValue());
                AttributeValue creditsNo = item.getOrDefault("creditsNo", new AttributeValue());
                AttributeValue periodsNo = item.getOrDefault("periodsNo", new AttributeValue());
                AttributeValue deleted = item.getOrDefault("deleted", new AttributeValue());
                subjects.add(getSubjectViewModel(subjectId.getS(), subjectName.getS(), creditsNo.getS(), periodsNo.getS(), deleted.getS()));
            }

        }catch(Exception e){
            return null;
        }
        return subjects;
    }
}
