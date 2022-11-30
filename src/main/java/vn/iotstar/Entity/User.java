package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Builder // Viết method nối chuỗi
@Data
@Entity // tạo ra get set
@DynamoDBTable(tableName = "user")
public class User implements Serializable{
	
	@DynamoDBHashKey
    private String username;
	@DynamoDBAttribute	
    private String password;
	@DynamoDBAttribute
    private String roleid;
	@DynamoDBAttribute
    private int deleted;

}
