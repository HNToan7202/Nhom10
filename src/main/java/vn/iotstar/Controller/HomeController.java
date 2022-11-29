package vn.iotstar.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {
	@GetMapping
	public String Home()
	{
		return "Hell0";
	}
	@GetMapping("/CreateAllTable")
	public void CreateTable() {
		
	}
	
	
}
