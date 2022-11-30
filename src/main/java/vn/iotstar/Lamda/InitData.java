package vn.iotstar.Lamda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import vn.iotstar.StudentManagementProjectCloudApplication;
import vn.iotstar.Config.AWSDynamoDB;
import vn.iotstar.Config.AWSS3;
import vn.iotstar.utils.UserUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;

public class InitData {
	public static void main(String[] args) {
		//DropAllTable();
		InitialData();
		//GenerateTable();
	}

	private static void InitialData() {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable("faculty");
		try {

			Item item = new Item().withPrimaryKey("facultyId", "FIT").withString("facultyName", "Công nghệ thông tin")
					.withString("image",
							AWSS3.getInstance().uploadFile("FIT.png",
									Files.newInputStream(new File("D:\\Finally Project Cloud\\FIT.png").toPath())))
					.withString("deleted", "0");
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("lecture");
		try {

			Item item = new Item().withPrimaryKey("lectureId", "GV01").withString("facultyId", "FIT")
					.withString("lectureName", "Nguyễn Minh Sơn").withString("dob", "10-10-2002")
					.withString("address", "TP Thủ Đức").withString("gender", "Nam").withString("phone", "0354964840")
					.withString("image",
							AWSS3.getInstance().uploadFile("DienThoai.jpg",
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
					.withString("password", UserUtils.hashPassword("admin")).withString("lectureId", "GV01")
					.withString("deleted", "0");
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("role");
		try {

			Item item = new Item().withPrimaryKey("roleId", "role1").withString("roleName", "Admin")
					.withString("deleted", "0");
			table.putItem(item);
			item = new Item().withPrimaryKey("roleId", "role2").withString("roleName", "Giảng viên")
					.withString("deleted", "0");
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("user_role");
		try {

			Item item = new Item().withPrimaryKey("username", "admin", "roleId", "role1");
			table.putItem(item);
			item = new Item().withPrimaryKey("username", "admin", "roleId", "role2");
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void StudentCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("student",
					Collections.singletonList(new KeySchemaElement("studentId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("studentId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Student table created successfully");
	}

	private static void SubjectCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("subject",
					Collections.singletonList(new KeySchemaElement("subjectId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("subjectId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Subject table created successfully");
	}

	private static void SubjectGroupCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("subject_group",
					Collections.singletonList(new KeySchemaElement("subjectGroupId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("subjectGroupId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Subject group table created successfully");
	}

	private static void FacultyCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("faculty",
					Collections.singletonList(new KeySchemaElement("facultyId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("facultyId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Faculty table created successfully");
	}

	private static void GradeCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("grade",
					Arrays.asList(new KeySchemaElement("studentId", KeyType.HASH),
							new KeySchemaElement("subjectGroupId", KeyType.RANGE)),
					Arrays.asList(new AttributeDefinition("studentId", ScalarAttributeType.S),
							new AttributeDefinition("subjectGroupId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Grade table created successfully");
	}

	private static void LectureCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("lecture",
					Collections.singletonList(new KeySchemaElement("lectureId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("lectureId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Lecture table created successfully");
	}

	private static void StudentClassCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("student_class",
					Collections.singletonList(new KeySchemaElement("studentClassId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("studentClassId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Student Class table created successfully");
	}

	private static void RoleCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("role",
					Collections.singletonList(new KeySchemaElement("roleId", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("roleId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Role table created successfully");
	}

	private static void UserCreator() {
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

	private static void UserRoleCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("user_role",
					Arrays.asList(new KeySchemaElement("username", KeyType.HASH),
							new KeySchemaElement("roleId", KeyType.RANGE)),
					Arrays.asList(new AttributeDefinition("username", ScalarAttributeType.S),
							new AttributeDefinition("roleId", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("User Role table created successfully");
	}

	public static void DropAllTable() {
		AmazonDynamoDB client = AWSDynamoDB.getInstance().getAmazonClient();
		client.listTables().getTableNames().forEach(client::deleteTable);
	}

	public static void GenerateTable() {
		StudentCreator();
		SubjectCreator();
		FacultyCreator();
		GradeCreator();
		LectureCreator();
		SubjectGroupCreator();
		StudentClassCreator();
		RoleCreator();
		UserCreator();
		UserRoleCreator();

	}
}
