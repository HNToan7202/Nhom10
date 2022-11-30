package vn.iotstar.Entity;

import java.io.Serializable;

import javax.persistence.Entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
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
@DynamoDBTable(tableName = "subject")
public class Subject implements Serializable {

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	private int id;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private int credits;
	@DynamoDBAttribute
	private int deleted;

}
