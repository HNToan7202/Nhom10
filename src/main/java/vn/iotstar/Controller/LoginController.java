
package vn.iotstar.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.User;
import vn.iotstar.Model.UserModel;
import vn.iotstar.Service.IAdminService;
import vn.iotstar.Service.ILectureService;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.Service.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdminService adminService;
	@Autowired
	private ILectureService lectureService;
	@Autowired
	private IStudentService studentService;

	@Autowired
	private HttpSession session;

	@GetMapping("login")
	public String login(ModelMap model) {

		return "/common/demologin";
	}

	@PostMapping("login")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("user") UserModel user, BindingResult result) {

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "loi"); return new
		 * ModelAndView("common/demologin", model); }
		 */

		User users = userService.login(user.getUsername(), user.getPassword());

		if (users == null) {
			model.addAttribute("message", "Tài khoản hoặc mật khẩu không chính xác");
			return new ModelAndView("common/demologin", model);
		} else {
			session.setAttribute("username", users.getUsername());
			String username = users.getUsername();

			List<Admin> admin = adminService.findByUsername(username);
			List<Lecture> lecture = lectureService.findByUsername(username);
			List<Student> student = studentService.findByUsername(username);

			if (admin.size() > 0) {
				model.addAttribute("user", admin.get(0));
				return new ModelAndView("redirect:/admin/home", model);
			} else if (lecture.size() > 0) {
				model.addAttribute("user", lecture.get(0));
				return new ModelAndView("redirect:/lecture/home", model);
			} else if (student.size() > 0) {
				model.addAttribute("user", student.get(0));
				return new ModelAndView("redirect:/student/home", model);
			} else {
				model.addAttribute("message", "Chưa có thông tin tài khoản trong hệ thống.");
				return new ModelAndView("common/demologin", model);
			}

		}
	}

}
