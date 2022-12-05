package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import vn.iotstar.Entity.Student;
@Component
public interface IStudentService {

	void deleteAll();

	void deleteAll(Iterable<? extends Student> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Student entity);

	void deleteById(String id);

	long count();

	Iterable<Student> findAllById(Iterable<String> ids);

	Iterable<Student> findAll();

	boolean existsById(String id);

	Optional<Student> findById(String id);

	<S extends Student> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Student> S save(S entity);

	Iterable<Student> findByNameContaining(String name);

	List<Student> findByUsername(String username);
}
