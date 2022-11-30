package vn.iotstar.Lamda;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

import vn.iotstar.Config.AWSDynamoDB;
import vn.iotstar.Config.AWSS3;
import vn.iotstar.utils.UserUtils;

@Controller
@RequestMapping("database")
public class CreateAllTable {

	@GetMapping("/create")
	public String create(ModelMap model) {
		String message = null;
		try {
			StudentCreator();
			SubjectCreator();
			SubjectGroupCreator();
			FacultyCreator();
			GradeCreator();
			LectureCreator();
			StudentClassCreator();
			RoleCreator();
			UserCreator();
			InitialData();
			message = "Create database success";
		} catch (Exception e) {
			message = e.getMessage();
		}
		model.addAttribute("message", message);
		return "admin/data/create";
	}

	private void StudentCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("student",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Student table created successfully");
	}

	private void SubjectCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("subject",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Subject table created successfully");
	}

	private void SubjectGroupCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("subject_group",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Subject group table created successfully");
	}

	private void FacultyCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("faculty",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Faculty table created successfully");
	}

	private void GradeCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("grade",
					Arrays.asList(new KeySchemaElement("id", KeyType.HASH), new KeySchemaElement("id", KeyType.RANGE)),
					Arrays.asList(new AttributeDefinition("mssv", ScalarAttributeType.S),
							new AttributeDefinition("subjectGroupId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Grade table created successfully");
	}

	private void LectureCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("lecture",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Lecture table created successfully");
	}

	private void StudentClassCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("student_class",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Student Class table created successfully");
	}

	private void RoleCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("role",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Role table created successfully");
	}

	private void UserCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("user",
					Collections.singletonList(new KeySchemaElement("username", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("username", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Student table created successfully");
	}

	private void InitialData() {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable("faculty");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("name", "Công nghệ thông tin")
					.withString("deleted", "0");
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("lecture");
		try {

			Item item = new Item().withPrimaryKey("id", "1")
					.withString("name", "Ngô Diệp Quang Huy").withString("facultyId", "FIT")
					.withString("address", "TP Thủ Đức").withString("gender", "Nam").withString("phone", "0354964840")
					.withString("image",
							AWSS3.getInstance().uploadFile("LectureQuangHuy.jpg",
									Files.newInputStream(
											new File("D:\\Finally Project Cloud\\DienThoai.jpg").toPath())))
					.withString("deleted", "0");
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("user");
		try {

			Item item = new Item().withPrimaryKey("username", "admin")
					.withString("password", UserUtils.hashPassword("admin")).withString("roleid", "1")
					.withString("deleted", "0");
			table.putItem(item);
			item = new Item().withPrimaryKey("username", "student")
					.withString("password", UserUtils.hashPassword("student")).withString("roleid", "2")
					.withString("deleted", "0");
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("role");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("name", "Admin")
					.withString("deleted", "0");
			table.putItem(item);
			item = new Item().withPrimaryKey("id", "2").withString("name", "Student")
					.withString("deleted", "0");
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
