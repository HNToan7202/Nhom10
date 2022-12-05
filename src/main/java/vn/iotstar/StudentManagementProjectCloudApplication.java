package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableCaching

@EnableRedisRepositories(basePackages = "vn.iotstar.Reponsitories")
@ComponentScan(basePackages = "vn.iotstar.*")
public class StudentManagementProjectCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementProjectCloudApplication.class, args);
	}

}
