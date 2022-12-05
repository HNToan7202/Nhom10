package vn.iotstar.Service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import vn.iotstar.Entity.StudentClass;
@Component
public interface IStudentClassService {

	void deleteAll();

	void deleteAll(Iterable<? extends StudentClass> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(StudentClass entity);

	void deleteById(String id);

	long count();

	Iterable<StudentClass> findAllById(Iterable<String> ids);

	Iterable<StudentClass> findAll();

	boolean existsById(String id);

	Optional<StudentClass> findById(String id);

	<S extends StudentClass> Iterable<S> saveAll(Iterable<S> entities);

	<S extends StudentClass> S save(S entity);

	Iterable<StudentClass> findByNameContaining(String name);

}
