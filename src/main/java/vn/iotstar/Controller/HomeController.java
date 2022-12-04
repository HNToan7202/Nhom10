package vn.iotstar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	
	@GetMapping
	public String Home(Model model)
	{
		return "common/demologin";
	}

	
	
}
