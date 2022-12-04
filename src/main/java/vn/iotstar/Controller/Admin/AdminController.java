package vn.iotstar.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Service.IAdminService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@RequestMapping("home")
	public String addGV(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Admin> admin = adminService.findByUsername(username);
		if (admin.size() > 0) {
			model.addAttribute("admin", admin.get(0));
		}
		return "admin/home";
	}

	@RequestMapping("addST")
	public String addST(Model model) {
		return "admin/student/add";
	}

	@RequestMapping("contact")
	public String contact(Model model) {

		return "admin/contact";
	}

	@RequestMapping("profile")
	public String proifile(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Admin> student = adminService.findByUsername(username);
		if (student.size() > 0) {
			model.addAttribute("admin", student.get(0));
			model.addAttribute("user", student.get(0));
			return "/admin/profile";
		}
		return "/admin/home";
	}

	@RequestMapping("error")
	public String chart(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Admin> admin = adminService.findByUsername(username);
		if (admin.size() > 0) {
			model.addAttribute("admin", admin.get(0));
		}
		return "/error";
	}

}
