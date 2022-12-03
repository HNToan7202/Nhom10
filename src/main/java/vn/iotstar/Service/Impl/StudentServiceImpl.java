package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Student;
import vn.iotstar.Reponsitories.IStudentRepository;
import vn.iotstar.Service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	
	@Autowired
	IStudentRepository studentRepo;

	@Override
	public Iterable<Student> findByNameContaining(String name) {
		return studentRepo.findByNameContaining(name);
	}

	@Override
	public <S extends Student> S save(S entity) {
		return studentRepo.save(entity);
	}

	@Override
	public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
		return studentRepo.saveAll(entities);
	}

	@Override
	public Optional<Student> findById(String id) {
		return studentRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return studentRepo.existsById(id);
	}

	@Override
	public Iterable<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Iterable<Student> findAllById(Iterable<String> ids) {
		return studentRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return studentRepo.count();
	}

	@Override
	public void deleteById(String id) {
		studentRepo.deleteById(id);
	}

	@Override
	public void delete(Student entity) {
		studentRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		studentRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Student> entities) {
		studentRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		studentRepo.deleteAll();
	}
	
}
