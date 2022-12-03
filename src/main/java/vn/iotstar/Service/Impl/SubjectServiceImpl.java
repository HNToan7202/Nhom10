package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Subject;
import vn.iotstar.Reponsitories.ISubjectRepository;
import vn.iotstar.Service.ISubjectService;

@Service
public class SubjectServiceImpl implements ISubjectService{

	@Autowired
	ISubjectRepository subjectRepo;

	@Override
	public Iterable<Subject> findByNameContaining(String name) {
		return subjectRepo.findByNameContaining(name);
	}

	@Override
	public <S extends Subject> S save(S entity) {
		return subjectRepo.save(entity);
	}

	@Override
	public <S extends Subject> Iterable<S> saveAll(Iterable<S> entities) {
		return subjectRepo.saveAll(entities);
	}

	@Override
	public Optional<Subject> findById(String id) {
		return subjectRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return subjectRepo.existsById(id);
	}

	@Override
	public Iterable<Subject> findAll() {
		return subjectRepo.findAll();
	}

	@Override
	public Iterable<Subject> findAllById(Iterable<String> ids) {
		return subjectRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return subjectRepo.count();
	}

	@Override
	public void deleteById(String id) {
		subjectRepo.deleteById(id);
	}

	@Override
	public void delete(Subject entity) {
		subjectRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		subjectRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Subject> entities) {
		subjectRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		subjectRepo.deleteAll();
	}
	
}
