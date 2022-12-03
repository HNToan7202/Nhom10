package vn.iotstar.Controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletContext;
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

import vn.iotstar.Entity.Student;
import vn.iotstar.Model.StudentModel;
import vn.iotstar.Service.IStudentService;

@Controller
@RequestMapping("admin/student")
public class StudentController {
	@Autowired
	IStudentService studentservice;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<Student> students = studentservice.findAll();
		model.addAttribute("students", students);
		return "admin/student/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		StudentModel student = new StudentModel();
		student.setIsEdit(false);
		model.addAttribute("student", student);
		return "admin/student/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Student> opt = studentservice.findById(id);
		StudentModel student = new StudentModel();
		if (opt.isPresent()) {
			Student entity = opt.get();
			BeanUtils.copyProperties(entity, student);
			student.setIsEdit(true);
			model.addAttribute("student", student);
			return new ModelAndView("admin/student/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("student") StudentModel student,
			BindingResult result) {
		Student entity = new Student();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/student/addOrEdit");
		}
		BeanUtils.copyProperties(student, entity);
		studentservice.save(entity);
		return new ModelAndView("redirect:/admin/student", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<Student> list = null;
		if (StringUtils.hasText(name))
			list = studentservice.findByNameContaining(name);
		else
			list = studentservice.findAll();

		model.addAttribute("students", list);
		return "admin/student/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		studentservice.deleteById(id);
		return new ModelAndView("redirect:/admin/student", model);
	}
}
