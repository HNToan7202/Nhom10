/*
 * package vn.iotstar.api;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.amazonaws.Response;
 * 
 * import vn.iotstar.Entity.Faculty; import vn.iotstar.Service.IFacultyService;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/faculty") public class AdminRedisController {
 * 
 * @Autowired IFacultyService facultyService;
 * 
 * @GetMapping("list") public ResponseEntity<Iterable<Faculty>> getall() {
 * return ResponseEntity.ok(facultyService.findAll()); }
 * 
 * @GetMapping("/getOne/{id}") public Optional<Faculty>
 * getOneInvoice(@PathVariable String id) { return facultyService.findById(id);
 * }
 * 
 * @PutMapping("/modify/{id}") public Faculty updateInvoice(@RequestBody Faculty
 * inv, @PathVariable String id) { return facultyService.save(inv); }
 * 
 * @DeleteMapping("/delete/{id}") public String deleteInvoice(@PathVariable
 * String id) { facultyService.deleteById(id); return "Employee with id: " + id
 * + " Deleted !"; } }
 */