package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.iotstar.Entity.Grade;
import vn.iotstar.Reponsitories.GradeRepository;
import vn.iotstar.dto.GradeRequest;

@RestController
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepo;

	@GetMapping
	public List<Grade> getAllGrade(){
		return gradeRepo.findAll();
	}
	
	@PostMapping("/grade/add")
	public Grade addGrade(@RequestBody GradeRequest gradeRequest) {
		return gradeRepo.saveGrade(new Grade(gradeRequest.subjectId(), gradeRequest.grade()));
	}

}
