package vn.iotstar.Controller.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Entity.Grade;
import vn.iotstar.Entity.Student;
import vn.iotstar.Entity.User;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.IAdminService;
import vn.iotstar.Service.IGradeService;
import vn.iotstar.Service.IStudentService;
import vn.iotstar.Service.IUserService;
import vn.iotstar.configuration.AWSS3;

@Controller
@RequestMapping("student")
public class StudentHomeController {

	@Autowired
	IStudentService studentService;

	@Autowired
	IGradeService gradeService;

	@Autowired
	ServletContext application;

	@Autowired
	IAdminService adminService;

	@Autowired
	IUserService userService;

	@Autowired
	private HttpSession session;

	public File convertToFile(MultipartFile multipartFile) throws FileNotFoundException, IOException {
		File file = new File("src/main/resources/targetFile.tmp");

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(multipartFile.getBytes());
		}
		return file;
	}

	@RequestMapping("home")
	public String home(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Student> student = studentService.findByUsername(username);
		if (student.size() > 0) {
			model.addAttribute("user", student.get(0));
		}
		return "/common/student/home";
	}

	@RequestMapping("needhelp")
	public String needhelp(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Student> student = studentService.findByUsername(username);
		if (student.size() > 0) {
			model.addAttribute("user", student.get(0));
		}
		return "/common/needhelp";
	}

	@RequestMapping("profile")
	public String proifile(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Student> student = studentService.findByUsername(username);
		if (student.size() > 0) {
			model.addAttribute("user", student.get(0));
			return "/common/student/profile";
		}
		return "/common/student/home";
	}

	@GetMapping("grade")
	public String getAllGrade(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Student> student = studentService.findByUsername(username);
		if (student.size() > 0) {
			model.addAttribute("user", student.get(0));
		}
		Iterable<Grade> grades = gradeService.findAll();
		model.addAttribute("grades", grades);
		return "common/student/grade";
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) throws FileNotFoundException, IOException {
		File file = convertToFile(student.getImageFile());
		Student entity = new Student();
		if (!student.getImageFile().isEmpty()) {
			try {
				student.setImage(AWSS3.getInstance().uploadFile(student.getImageFile().getOriginalFilename(),
						Files.newInputStream(file.toPath())));
				student.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(student, entity);
		studentService.save(entity);
		return new ModelAndView("redirect:/student/profile", model);
	}

	@GetMapping("my")
	public String getAllAccount(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<Student> student = studentService.findByUsername(username);
		List<User> account = userService.findByUsername(username);
		Optional<Admin> admin = adminService.findById("1");
		model.addAttribute("user", student.get(0));
		model.addAttribute("account", account.get(0));
		model.addAttribute("admin", admin.get());
		Iterable<Grade> grades = gradeService.findAll();
		model.addAttribute("grades", grades);
		return "common/student/myaccount";
	}

	@RequestMapping("chart")
	public String chart(Model model) {
		return "/common/student/chart";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Student> opt = studentService.findById(id);
		StudentModel student = new StudentModel();
		if (opt.isPresent()) {
			Student entity = opt.get();
			BeanUtils.copyProperties(entity, student);
			student.setIsEdit(true);
			model.addAttribute("student", student);
			return new ModelAndView("common/student/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/student/profile", model);

	}

	@PostMapping("account")
	public ModelAndView ProjectResgiter(ModelMap model, HttpSession sesson,
			@RequestParam(name = "password", required = false) String password,
			@RequestParam(name = "newpassword", required = false) String newpassword) {
		String username = (String) sesson.getValue("username");
		List<Student> student = studentService.findByUsername(username);
		User account = userService.login(username, password);
		model.addAttribute("user", student.get(0));
		if (account == null) {
			model.addAttribute("message", "Mật khẩu không chính xác");
			return new ModelAndView("common/student/account", model);
		}
		User acc = account;
		acc.setPassword(newpassword);
		userService.save(acc);
		model.addAttribute("message", "Mật khẩu đã được cập nhật");
		return new ModelAndView("common/student/profile", model);
	}

	@GetMapping("account")
	public String AccountStudent(ModelMap model, HttpSession sesson) {
		String username = (String) sesson.getValue("username");
		List<Student> studententity = studentService.findByUsername(username);
		StudentModel student = new StudentModel();
		BeanUtils.copyProperties(studententity.get(0), student);
		model.addAttribute("user", student);
		return "common/student/account";
	}
}
