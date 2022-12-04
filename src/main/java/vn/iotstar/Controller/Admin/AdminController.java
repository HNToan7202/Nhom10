package vn.iotstar.Controller.Admin;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.User;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.IAdminService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@RequestMapping("addGV")
	public String addGV(Model model) {
		return "admin/lecture/add";
	}

	@RequestMapping("addST")
	public String addST(Model model) {
		return "admin/student/add";
	}

	@RequestMapping("contact")
	public String contact(Model model) {
		return "admin/contact";
	}

}
