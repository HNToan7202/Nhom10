
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


import vn.iotstar.Entity.Grade;
import vn.iotstar.Model.GradeModel;
import vn.iotstar.Service.IGradeService;

@Controller

@RequestMapping("admin/grade")
public class GradeController {

	@Autowired
	IGradeService gradeService;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<Grade> grades = gradeService.findAll();
		model.addAttribute("grades", grades);
		return "admin/grade/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		GradeModel grade = new GradeModel();
		grade.setIsEdit(false);
		model.addAttribute("grade", grade);
		return "admin/	/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Grade> opt = gradeService.findById(id);
		GradeModel grade = new GradeModel();
		if (opt.isPresent()) {
			Grade entity = opt.get();
			BeanUtils.copyProperties(entity, grade);
			grade.setIsEdit(true);
			model.addAttribute("grade", grade);
			return new ModelAndView("admin/grade/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("grade") GradeModel grade,
			BindingResult result) {
		Grade entity = new Grade();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/grade/addOrEdit");
		}
		BeanUtils.copyProperties(grade, entity);
		gradeService.save(entity);
		return new ModelAndView("redirect:/admin/grade", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "subjectId", required = false) String subject) {
		Iterable<Grade> list = null;
		if (StringUtils.hasText(subject))
			list = gradeService.findBySubjectIdContaining(subject);
		else
			list = gradeService.findAll();

		model.addAttribute("grades", list);
		return "admin/grade/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		gradeService.deleteById(id);
		return new ModelAndView("redirect:/admin/grade", model);
	}
}
