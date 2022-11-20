package vn.iotstar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Reponsitories.FacultyRepository;
import vn.iotstar.dto.FacultyRequest;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private FacultyRepository facultyRepo;

	@GetMapping()
	public 	String add(ModelMap model) {
		model.addAttribute("faculty",new Faculty());
		return "/faculty/addOrEdit";
	}
	

}
