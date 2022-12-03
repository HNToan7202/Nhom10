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

import vn.iotstar.Entity.StudentClass;
import vn.iotstar.Model.StudentClassModel;
import vn.iotstar.Service.IStudentClassService;

@Controller
@RequestMapping("admin/studentclass")
public class StudentClassController {
	@Autowired
	IStudentClassService studentclassService;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<StudentClass> studentclasses = studentclassService.findAll();
		model.addAttribute("studentclasses", studentclasses);
		return "admin/studentclass/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		StudentClassModel StudentClass = new StudentClassModel();
		StudentClass.setIsEdit(false);
		model.addAttribute("studentclass", StudentClass);
		return "admin/studentclass/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<StudentClass> opt = studentclassService.findById(id);
		StudentClassModel StudentClass = new StudentClassModel();
		if (opt.isPresent()) {
			StudentClass entity = opt.get();
			BeanUtils.copyProperties(entity, StudentClass);
			StudentClass.setIsEdit(true);
			model.addAttribute("studentclass", StudentClass);
			return new ModelAndView("admin/studentclass/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model,
			@Valid @ModelAttribute("studentclass") StudentClassModel StudentClass, BindingResult result) {
		StudentClass entity = new StudentClass();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/studentclass/addOrEdit");
		}
		BeanUtils.copyProperties(StudentClass, entity);
		studentclassService.save(entity);
		return new ModelAndView("redirect:/admin/studentclass", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<StudentClass> list = null;
		if (StringUtils.hasText(name))
			list = studentclassService.findByNameContaining(name);
		else
			list = studentclassService.findAll();

		model.addAttribute("studentclasses", list);
		return "admin/studentclass/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		studentclassService.deleteById(id);
		return new ModelAndView("redirect:/admin/studentclass", model);
	}
}
