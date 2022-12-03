package vn.iotstar.Service;

import java.util.Optional;

import vn.iotstar.Entity.Faculty;

public interface IFacultyService {

	void deleteAll();

	void deleteAll(Iterable<? extends Faculty> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Faculty entity);

	void deleteById(String id);

	long count();

	Iterable<Faculty> findAllById(Iterable<String> ids);

	Iterable<Faculty> findAll();

	boolean existsById(String id);

	Optional<Faculty> findById(String id);

	<S extends Faculty> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Faculty> S save(S entity);

	Iterable<Faculty> findByNameContaining(String name);

}
