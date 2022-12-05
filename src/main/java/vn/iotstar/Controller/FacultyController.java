package vn.iotstar.Controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Model.FacultyModel;
import vn.iotstar.Service.IFacultyService;
/*import vn.iotstar.Service.IFacultyService;*/

@Controller
@RequestMapping("admin/faculty")
public class FacultyController {
	@Autowired
	IFacultyService facultyService;

	@Autowired
	ServletContext application;

	@GetMapping("")
	@Cacheable(value = "faculties")
	public String getAllGrade(ModelMap model) {
		Iterable<Faculty> faculties = facultyService.findAll();
		model.addAttribute("faculties", faculties);
		return "admin/faculty/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		FacultyModel faculty = new FacultyModel();
		faculty.setIsEdit(false);
		model.addAttribute("faculty", faculty);
		return "admin/faculty/addOrEdit";
	}

	@GetMapping("edit/{id}")
	@Cacheable(value = "faculty")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Faculty> opt = facultyService.findById(id);
		FacultyModel faculty = new FacultyModel();
		if (opt.isPresent()) {
			Faculty entity = opt.get();
			BeanUtils.copyProperties(entity, faculty);
			faculty.setIsEdit(true);
			model.addAttribute("faculty", faculty);
			return new ModelAndView("admin/faculty/addOrEdit", model);
		}
		model.addAttribute("message", "Student không tồn tại");
		return new ModelAndView("redirect:/admin/student", model);

	}

	@Caching(put = { @CachePut(value = "faculty", key = "#faculty.id") }, evict = { @CacheEvict(value = "faculties") })
	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("faculty") FacultyModel faculty,
			BindingResult result) {
		Faculty entity = new Faculty();

		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi");
			return new ModelAndView("admin/faculty/addOrEdit");
		}
		BeanUtils.copyProperties(faculty, entity);
		facultyService.save(entity);
		return new ModelAndView("redirect:/admin/faculty", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<Faculty> list = null;
		if (StringUtils.hasText(name))
			list = facultyService.findByNameContaining(name);
		else
			list = facultyService.findAll();

		model.addAttribute("faculties", list);
		return "admin/faculty/search";
	}

	@Caching(evict = { @CacheEvict(value = "faculty", key = "#id"), @CacheEvict(value = "faculties") })
	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		facultyService.deleteById(id);
		return new ModelAndView("redirect:/admin/faculty", model);
	}

}
