package vn.iotstar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.iotstar.Reponsitories.FacultyRepository;



//@RestController  // =  @Controller + @ResponeBody


//@RequestMapping("/faculty")
@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private FacultyRepository facultyRepo;

	//@PostMapping(value = "/faculty")  // @RequestMapping + method
	public 	String createFaculty() {
		
		//model.addAttribute("faculty",new Faculty());
		//return "/faculty/addOrEdit";
		return "index";
	}
//	@PutMapping(value = "/faculty")
//	public Faculty updateFaculty(@RequestBody Faculty model)
//	{
//		return model;
//	}
//	@DeleteMapping(value = "/faculty")
//	public void deleteFaculty(@RequestBody long[] model)
//	{
//		
//	}

}
