package vn.iotstar.servicesImpl;

import vn.iotstar.Entity.Grade;
import vn.iotstar.repositoryImpl.GradeRepository;
import vn.iotstar.services.IGradeService;

import java.util.ArrayList;

public class GradeServiceImpl implements IGradeService {
	private static GradeServiceImpl instance = null;

	public static GradeServiceImpl getInstance() {
		if (instance == null)
			instance = new GradeServiceImpl();
		return instance;
	}

	@Override
	public boolean insert(Grade request) {
		return GradeRepository.getInstance().insert(request);
	}

	@Override
	public boolean update(Grade request) {
		return GradeRepository.getInstance().update(request);
	}

	@Override
	public boolean delete(String hashKey, String rangeKey) {
		return GradeRepository.getInstance().delete(hashKey, rangeKey);
	}

	@Override
	public Grade retrieveById(String hashKey, String rangeKey) {
		return GradeRepository.getInstance().retrieveById(hashKey, rangeKey);
	}

	@Override
	public ArrayList<Grade> retrieveAll() {
		return GradeRepository.getInstance().retrieveAll();
	}

	@Override
	public boolean containStudent(String studentId) {
		return GradeRepository.getInstance().containStudent(studentId);
	}

	@Override
	public boolean containSubjectGroup(String subjectGroupId) {
		return GradeRepository.getInstance().containSubjectGroup(subjectGroupId);
	}

	@Override
	public ArrayList<Grade> retrieveGradeByLectureId(String lectureId) {
		return GradeRepository.getInstance().retrieveGradeByLectureId(lectureId);
	}
}
