package vn.iotstar.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
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
import vn.iotstar.Entity.Admin;
import vn.iotstar.Model.AdminModel;
import vn.iotstar.Service.IAdminService;

@Controller
@RequestMapping("admin")
public class AdminControllerCRUD {
	@Autowired
	IAdminService adminservice;

	@Autowired
	ServletContext application;

	@GetMapping("")
	public String getAllGrade(ModelMap model) {
		Iterable<Admin> admins = adminservice.findAll();
		model.addAttribute("admins", admins);
		return "admin/adminCRUD/list";
	}

	@GetMapping("add")
	public String add(Model model) {
		AdminModel admin = new AdminModel();
		admin.setIsEdit(false);
		model.addAttribute("admin", admin);
		return "admin/adminCRUD/addOrEdit";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") String id) throws IOException {
		Optional<Admin> opt = adminservice.findById(id);
		AdminModel admin = new AdminModel();
		if (opt.isPresent()) {
			Admin entity = opt.get();
			BeanUtils.copyProperties(entity, admin);
			admin.setIsEdit(true);
			model.addAttribute("admin", admin);
			return new ModelAndView("admin/adminCRUD/addOrEdit", model);
		}
		model.addAttribute("message", "admin không tồn tại");
		return new ModelAndView("redirect:/admin", model);

	}

	public File convertToFile(MultipartFile multipartFile) throws FileNotFoundException, IOException {
		File file = new File("src/main/resources/targetFile.tmp");

		try (OutputStream os = new FileOutputStream(file)) {
			os.write(multipartFile.getBytes());
		}
		return file;
	}

	@PostMapping("saveofUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("admin") AdminModel admin,
			BindingResult result) throws FileNotFoundException, IOException {
		File file = convertToFile(admin.getImageFile());
		Admin entity = new Admin();

		/*
		 * if (result.hasErrors()) { model.addAttribute("message", "Có lỗi"); return new
		 * ModelAndView("admin/admin/addOrEdit"); }
		 */
		if (!admin.getImageFile().isEmpty()) {
			try {
				admin.setImage(AWSS3.getInstance().uploadFile(admin.getImageFile().getOriginalFilename(),
						Files.newInputStream(file.toPath())));
				admin.setImageFile(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		BeanUtils.copyProperties(admin, entity);
		adminservice.save(entity);
		return new ModelAndView("redirect:/admin", model);
	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		Iterable<Admin> list = null;
		if (StringUtils.hasText(name))
			list = adminservice.findByNameContaining(name);
		else
			list = adminservice.findAll();

		model.addAttribute("admins", list);
		return "admin/adminCRUD/search";
	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") String id) {
		adminservice.deleteById(id);
		return new ModelAndView("redirect:/admin", model);
	}
}
