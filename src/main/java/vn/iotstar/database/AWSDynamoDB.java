package vn.iotstar.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

@Configuration
public class AWSDynamoDB {
	private static AWSDynamoDB instance = null;
	private static final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
			.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("https://dynamodb.us-east-1.amazonaws.com", "us-east-1"))
			.build();

	private static DynamoDB dynamoDB;

	public static AWSDynamoDB getInstance() {
		if (instance == null) {
			instance = new AWSDynamoDB();
		}
		return instance;

	}

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(getAmazonClient());
		
	}
	
	@Bean
	public DynamoDB getDynamoDB() {
		if (dynamoDB == null)
			dynamoDB = new DynamoDB(client);
		return dynamoDB;
	}

	public AmazonDynamoDB getAmazonClient() {
		return client;
	}
}
