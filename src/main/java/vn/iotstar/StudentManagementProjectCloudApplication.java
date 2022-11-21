package vn.iotstar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.aws.context.config.annotation.ContextStackConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(exclude = {ContextStackConfiguration.class })
public class StudentManagementProjectCloudApplication {
	
	//spring.profiles.active=production
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@Value("${cloud.aws.end-point.uri}")
	private String endpoint;
	

	public void sendMessageToQueue(@PathVariable String message)
	{
		queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
	}
	
	@Profile("production")
	public static void main(String[] args) {
		
		SpringApplication.run(StudentManagementProjectCloudApplication.class, args);
	}
	

}
