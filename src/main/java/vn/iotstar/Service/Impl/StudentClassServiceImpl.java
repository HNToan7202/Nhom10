package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.StudentClass;
import vn.iotstar.Reponsitories.IStudentClassRepository;
import vn.iotstar.Service.IStudentClassService;



@Service
public class StudentClassServiceImpl implements IStudentClassService{

	@Autowired
	IStudentClassRepository studentclassRepo;

	@Override
	public Iterable<StudentClass> findByNameContaining(String name) {
		return studentclassRepo.findByNameContaining(name);
	}

	@Override
	public <S extends StudentClass> S save(S entity) {
		return studentclassRepo.save(entity);
	}

	@Override
	public <S extends StudentClass> Iterable<S> saveAll(Iterable<S> entities) {
		return studentclassRepo.saveAll(entities);
	}

	@Override
	public Optional<StudentClass> findById(String id) {
		return studentclassRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return studentclassRepo.existsById(id);
	}

	@Override
	public Iterable<StudentClass> findAll() {
		return studentclassRepo.findAll();
	}

	@Override
	public Iterable<StudentClass> findAllById(Iterable<String> ids) {
		return studentclassRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return studentclassRepo.count();
	}

	@Override
	public void deleteById(String id) {
		studentclassRepo.deleteById(id);
	}

	@Override
	public void delete(StudentClass entity) {
		studentclassRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		studentclassRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends StudentClass> entities) {
		studentclassRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		studentclassRepo.deleteAll();
	}
	
}
