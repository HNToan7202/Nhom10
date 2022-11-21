package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public List<Faculty> getAllGrade(){
		return facultyRepo.findAll();
	}
	
	@PostMapping("/faculty/add")
	public Faculty addFaculty(@RequestBody FacultyRequest facultyRequest) {
		return facultyRepo.saveFaculty(new Faculty(facultyRequest.facultyName(), facultyRequest.image(), facultyRequest.deleted()));
	}

}
