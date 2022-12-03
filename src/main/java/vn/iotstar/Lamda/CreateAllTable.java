
package vn.iotstar.Lamda;

import java.io.File;
import java.nio.file.Files;
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

@Controller
@RequestMapping("database")
public class CreateAllTable {

	@GetMapping("/creategrade")
	public String Grade(ModelMap model) {
		String message = null;
		try {
			InitialGrade();
			message = "Create database success";
		} catch (Exception e) {
			message = e.getMessage();
		}
		model.addAttribute("message", message);
		return "admin/data/create";
	}

	@GetMapping("/create")
	public String create(ModelMap model) {
		String message = null;
		try {
			StudentCreator();
			SubjectCreator();
			FacultyCreator();
			GradeCreator();
			LectureCreator();
			StudentClassCreator();
			RoleCreator();
			UserCreator();
			AdminCreator();
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

	private void AdminCreator() {
		try {
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("admin",
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return;
		}
		System.out.println("Admin table created successfully");
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
					Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
					Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
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
			Table table = AWSDynamoDB.getInstance().getDynamoDB().createTable("studentclass",
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

	private void InitialGrade() {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable("grade");
		try {

			Item item = new Item().withPrimaryKey("id", "FIT").withInt("mssv", 20110650).withFloat("grade", (float) 5.5)
					.withString("subjectId", "ad").withInt("deleted", 0);
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	private void InitialData() {
		Table table = AWSDynamoDB.getInstance().getDynamoDB().getTable("faculty");
		try {

			Item item = new Item().withPrimaryKey("id", "FIT").withString("name", "Công nghệ thông tin")
					.withInt("deleted", 0);
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("admin");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("username", "admin01")
					.withString("name", "Nguyễn Công Danh").withString("phone", "0354964840")
					.withString("image",
							AWSS3.getInstance().uploadFile("Admin.jpg",
									Files.newInputStream(new File("D:\\Finally Project Cloud\\admin.jpg").toPath())))
					.withInt("deleted", 0);
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("lecture");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("username", "lecture01")
					.withString("name", "Ngô Diệp Quang Huy").withString("facultyId", "FIT")
					.withString("address", "TP Thủ Đức").withString("dob", "05/10/2002").withString("gender", "Nam")
					.withString("phone", "0354964840")
					.withString("image",
							AWSS3.getInstance().uploadFile("LectureQuangHuy.jpg",
									Files.newInputStream(
											new File("D:\\Finally Project Cloud\\DienThoai.jpg").toPath())))
					.withInt("deleted", 0);
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("user");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("username", "admin01")
					.withString("password", "admin").withString("roleid", "admin").withInt("deleted", 0);
			table.putItem(item);
			item = new Item().withPrimaryKey("id", "2").withString("username", "lecture01")
					.withString("password", "lecture").withString("roleid", "lecture").withInt("deleted", 0);
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("role");
		try {

			Item item = new Item().withPrimaryKey("id", "admin").withString("name", "Admin").withInt("deleted", 0);
			table.putItem(item);
			item = new Item().withPrimaryKey("id", "lecture").withString("name", "Lecture").withInt("deleted", 0);
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("student");
		try {

			Item item = new Item().withPrimaryKey("id", "1").withString("mssv", "20110650")
					.withString("studentClassId", "201101C").withString("name", "Ngô Diệp Quang Huy")
					.withString("dob", "05/10/2002")
					.withString("image",
							AWSS3.getInstance().uploadFile("LectureQuangHuy.jpg",
									Files.newInputStream(
											new File("D:\\Finally Project Cloud\\DienThoai.jpg").toPath())))
					.withString("address", "TP Thủ Đức").withString("gender", "Nam").withString("phone", "0354964840")

					.withInt("deleted", 0).withString("facultyId", "FIT");
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("studentclass");
		try {

			Item item = new Item().withPrimaryKey("id", "201101C").withString("name", "Công nghệ thông tin 1")
					.withString("facultyId", "FIT").withInt("deleted", 0);
			table.putItem(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		table = AWSDynamoDB.getInstance().getDynamoDB().getTable("subject");
		try {

			Item item = new Item().withPrimaryKey("id", "SE").withString("name", "Công nghệ phần mềm")
					.withInt("credits", 3).withInt("deleted", 0);
			table.putItem(item);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}

}
