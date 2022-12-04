package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.Reponsitories.ILectureRepository;
import vn.iotstar.Service.ILectureService;

@Service
public class LectureServiceImpl implements ILectureService {

	
	@Autowired
	ILectureRepository lectureRepo;

	@Override
	public Iterable<Lecture> findByNameContaining(String name) {
		return lectureRepo.findByNameContaining(name);
	}

	@Override
	public <S extends Lecture> S save(S entity) {
		return lectureRepo.save(entity);
	}

	@Override
	public <S extends Lecture> Iterable<S> saveAll(Iterable<S> entities) {
		return lectureRepo.saveAll(entities);
	}

	@Override
	public Optional<Lecture> findById(String id) {
		return lectureRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return lectureRepo.existsById(id);
	}

	@Override
	public Iterable<Lecture> findAll() {
		return lectureRepo.findAll();
	}

	@Override
	public Iterable<Lecture> findAllById(Iterable<String> ids) {
		return lectureRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return lectureRepo.count();
	}

	@Override
	public void deleteById(String id) {
		lectureRepo.deleteById(id);
	}

	@Override
	public void delete(Lecture entity) {
		lectureRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		lectureRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Lecture> entities) {
		lectureRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		lectureRepo.deleteAll();
	}
	@Override
	public List<Lecture> findByUsername(String username) {
		return lectureRepo.findByUsername(username);
	}
	
	
}
