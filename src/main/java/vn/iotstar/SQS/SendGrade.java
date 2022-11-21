/*
 * package vn.iotstar.SQS;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import com.amazonaws.services.sqs.AmazonSQS; import
 * com.amazonaws.services.sqs.AmazonSQSClientBuilder; import
 * com.amazonaws.services.sqs.model.MessageAttributeValue;
 * 
 * public class SendGrade { public static void main(String[] args) { AmazonSQS
 * sqs = AmazonSQSClientBuilder.standard() .build(); String queueUrl ="";
 * Map<String ,MessageAttributeValue> messageAttributes = new HashMap<>();
 * messageAttributes.put("Name", null)
 * 
 * } }
 */


package vn.iotstar.SQS;

import com.amazonaws.services.sqs.AmazonSQS;

import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendGrade{
	public static void main(String [] args) {
		AmazonSQS sqs = AmazonSQSClientBuilder.standard() .build();
		
		String queueURL ="https://sqs.us-east-1.amazonaws.com/636633430012/gradeSQS";
		
		ReceiveMessageRequest re_request = new ReceiveMessageRequest()
				.withQueueUrl(queueURL)
				//.withWaitTimeSeconds(20)
				.withVisibilityTimeout(30)
				.withMaxNumberOfMessages(10);
		List<Message> message = sqs.receiveMessage(re_request).getMessages();
		
		for (Message m : message)
		{
			System.out.print(m.toString());
		}
	}
}