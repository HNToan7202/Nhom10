package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Grade;
import vn.iotstar.Reponsitories.IGradeRepository;
import vn.iotstar.Service.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService{
	@Autowired
	IGradeRepository gradeRepo;

	@Override
	public <S extends Grade> S save(S entity) {
		return gradeRepo.save(entity);
	}

	@Override
	public <S extends Grade> Iterable<S> saveAll(Iterable<S> entities) {
		return gradeRepo.saveAll(entities);
	}

	@Override
	public Optional<Grade> findById(String id) {
		return gradeRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return gradeRepo.existsById(id);
	}

	@Override
	public Iterable<Grade> findAll() {
		return gradeRepo.findAll();
	}

	@Override
	public Iterable<Grade> findAllById(Iterable<String> ids) {
		return gradeRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return gradeRepo.count();
	}

	@Override
	public void deleteById(String id) {
		gradeRepo.deleteById(id);
	}

	@Override
	public void delete(Grade entity) {
		gradeRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		gradeRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Grade> entities) {
		gradeRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		gradeRepo.deleteAll();
	}

	@Override
	public Iterable<Grade> findBySubjectIdContaining(String subjectId) {
		return gradeRepo.findBySubjectIdContaining(subjectId);
	}

	@Override
	public Iterable<Grade> findByMssvContaining(Integer MSSV) {
		return gradeRepo.findByMssvContaining(MSSV);
	}
	
	
}
