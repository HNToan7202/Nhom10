package vn.iotstar.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Service.IAdminService;

@Controller
@RequestMapping("")
public class HomeController {

	@Autowired
	IAdminService adminService;

	@GetMapping
	public String Home(ModelMap model, HttpSession session) {

		String username = (String) session.getAttribute("username");
		List<Admin> admin = adminService.findByUsername(username);
		if (admin.size() > 0) {
			model.addAttribute("admin", admin.get(0));
		}
		return "common/demologin";
	}

}
