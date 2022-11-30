package vn.iotstar.Lamda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import vn.iotstar.Config.AWSDynamoDB;

@Controller
@RequestMapping("database")
public class DeleteDatabase {

	@GetMapping("/delete")
	public String create(ModelMap model) {
		try {
			
			AmazonDynamoDB client = AWSDynamoDB.getInstance().getAmazonClient();
			client.listTables().getTableNames().forEach(client::deleteTable);
			model.addAttribute("message","Xóa thành công");
			return "index";
		} catch (Exception e) {
			model.addAttribute("message","Xóa thất bại");
			return "index";
		}
	}
}
