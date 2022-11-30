package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Reponsitories.FacultyRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private FacultyRepository facultyRepo;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		List<Faculty> faculties = facultyRepo.findAll();
		model.addAttribute("faculties", faculties);
		return "faculty/list";
	}
}
