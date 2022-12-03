
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

import vn.iotstar.Entity.Subject;
import vn.iotstar.Model.SubjectModel;
import vn.iotstar.Service.ISubjectService;

@Controller

@RequestMapping("admin/subject")
public class SubjectController {

	@Autowired
	ISubjectService subjectService;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<Subject> subjects = subjectService.findAll();
		model.addAttribute("subjects", subjects);
		return "admin/subject/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		SubjectModel subject = new SubjectModel();
		subject.setIsEdit(false);
		model.addAttribute("subject", subject);
		return "admin/subject/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Subject> opt = subjectService.findById(id);
		SubjectModel subject = new SubjectModel();
		if (opt.isPresent()) {
			Subject entity = opt.get();
			BeanUtils.copyProperties(entity, subject);
			subject.setIsEdit(true);
			model.addAttribute("subject", subject);
			return new ModelAndView("admin/subject/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("subject") SubjectModel subject,
			BindingResult result) {
		Subject entity = new Subject();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/subject/addOrEdit");
		}
		BeanUtils.copyProperties(subject, entity);
		subjectService.save(entity);
		return new ModelAndView("redirect:/admin/subject", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<Subject> list = null;
		if (StringUtils.hasText(name))
			list = subjectService.findByNameContaining(name);
		else
			list = subjectService.findAll();

		model.addAttribute("subjects", list);
		return "admin/subject/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		subjectService.deleteById(id);
		return new ModelAndView("redirect:/admin/subject", model);
	}
}
