package vn.iotstar.Service;

import java.util.Optional;

import vn.iotstar.Entity.Grade;

public interface IGradeService {

	void deleteAll();

	void deleteAll(Iterable<? extends Grade> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Grade entity);

	void deleteById(String id);

	long count();

	Iterable<Grade> findAllById(Iterable<String> ids);

	Iterable<Grade> findAll();

	boolean existsById(String id);

	Optional<Grade> findById(String id);

	<S extends Grade> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Grade> S save(S entity);

	Iterable<Grade> findByMssvContaining(Integer MSSV);

	Iterable<Grade> findBySubjectIdContaining(String subjectId);

}
