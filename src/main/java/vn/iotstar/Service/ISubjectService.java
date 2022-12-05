package vn.iotstar.Service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import vn.iotstar.Entity.Subject;
@Component
public interface ISubjectService {

	void deleteAll();

	void deleteAll(Iterable<? extends Subject> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Subject entity);

	void deleteById(String id);

	long count();

	Iterable<Subject> findAllById(Iterable<String> ids);

	Iterable<Subject> findAll();

	boolean existsById(String id);

	Optional<Subject> findById(String id);

	<S extends Subject> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Subject> S save(S entity);

	Iterable<Subject> findByNameContaining(String name);

}
