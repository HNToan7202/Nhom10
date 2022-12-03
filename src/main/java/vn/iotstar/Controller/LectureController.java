package vn.iotstar.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.iotstar.Config.AWSS3;
import vn.iotstar.Entity.Lecture;
import vn.iotstar.Model.LectureModel;
import vn.iotstar.Service.ILectureService;

@Controller
@RequestMapping("admin/lecture")
public class LectureController {
	@Autowired
	ILectureService lectureservice;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<Lecture> lectures = lectureservice.findAll();
		model.addAttribute("lectures", lectures);
		return "admin/lecture/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		LectureModel lecture = new LectureModel();
		lecture.setIsEdit(false);
		model.addAttribute("lecture", lecture);
		return "admin/lecture/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Lecture> opt = lectureservice.findById(id);
		LectureModel lecture = new LectureModel();
		if (opt.isPresent()) {
			Lecture entity = opt.get();
			BeanUtils.copyProperties(entity, lecture);
			lecture.setIsEdit(true);
			model.addAttribute("lecture", lecture);
			return new ModelAndView("admin/lecture/addOrEdit", model);
		}
		model.addAttribute("message", "lecture không tồn tại");
		return new ModelAndView("redirect:/admin/lecture", model);

	}

	public File convertToFile(MultipartFile multipartFile) throws FileNotFoundException, IOException {
		File file = new File("src/main/resources/targetFile.tmp");

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(multipartFile.getBytes());
		}
		return file;
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("lecture") LectureModel lecture,
			BindingResult result) throws FileNotFoundException, IOException {
		File file = convertToFile(lecture.getImageFile());
		Lecture entity = new Lecture();

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/lecture/addOrEdit"); }
		 */
		if (!lecture.getImageFile().isEmpty()) {
			try {
				lecture.setImage(AWSS3.getInstance().uploadFile(lecture.getImageFile().getOriginalFilename(),
						Files.newInputStream(file.toPath())));
				lecture.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(lecture, entity);
		lectureservice.save(entity);
		return new ModelAndView("redirect:/admin/lecture", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<Lecture> list = null;
		if (StringUtils.hasText(name))
			list = lectureservice.findByNameContaining(name);
		else
			list = lectureservice.findAll();

		model.addAttribute("lectures", list);
		return "admin/lecture/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		lectureservice.deleteById(id);
		return new ModelAndView("redirect:/admin/lecture", model);
	}
}
