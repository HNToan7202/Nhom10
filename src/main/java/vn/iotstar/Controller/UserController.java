package vn.iotstar.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.User;
import vn.iotstar.Model.UserModel;
import vn.iotstar.Service.IAdminService;
import vn.iotstar.Service.IUserService;

@Controller
@RequestMapping("admin/user")
public class UserController {
	@Autowired
	IUserService userService;

	@Autowired
	ServletContext application;
	
	@Autowired
	IAdminService adminService;

	@GetMapping("")
	public String getAllGrade(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Admin> admin = adminService.findByUsername(username);
		if (admin.size() > 0) {
			model.addAttribute("admin", admin.get(0));
		}
		Iterable<User> user = userService.findAll();
		model.addAttribute("users", user);
		return "admin/user/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		UserModel user = new UserModel();
		user.setIsEdit(false);
		model.addAttribute("user", user);
		return "admin/user/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<User> opt = userService.findById(id);
		UserModel user = new UserModel();
		if (opt.isPresent()) {
			User entity = opt.get();
			BeanUtils.copyProperties(entity, user);
			user.setIsEdit(true);
			model.addAttribute("user", user);
			return new ModelAndView("admin/user/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("user") UserModel user,
			BindingResult result) {
		User entity = new User();
		/*
		 * if (result.hasErrors()) { model.addAttribute("message",
		 * result.getErrorCount()); return new ModelAndView("admin/user/addOrEdit"); }
		 */
		BeanUtils.copyProperties(user, entity);
		userService.save(entity);
		return new ModelAndView("redirect:/admin/user", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "username", required = false) String name) {
		Iterable<User> list = null;
		if (StringUtils.hasText(name))
			list = userService.findByUsernameContaining(name);
		else
			list = userService.findAll();

		model.addAttribute("users", list);
		return "admin/user/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		userService.deleteById(id);
		return new ModelAndView("redirect:/admin/user", model);
	}
}
