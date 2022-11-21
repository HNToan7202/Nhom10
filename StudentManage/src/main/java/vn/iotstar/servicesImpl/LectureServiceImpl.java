package vn.iotstar.servicesImpl;

import vn.iotstar.Entity.Lecture;
import vn.iotstar.repositoryImpl.LectureRepository;
import vn.iotstar.services.ILectureService;

import java.util.ArrayList;

public class LectureServiceImpl implements ILectureService {
	private static LectureServiceImpl instance = null;

	public static LectureServiceImpl getInstance() {
		if (instance == null)
			instance = new LectureServiceImpl();
		return instance;
	}

	@Override
	public boolean insert(Lecture request) {
		return LectureRepository.getInstance().insert(request);
	}

	@Override
	public boolean update(Lecture request) {
		return LectureRepository.getInstance().update(request);
	}

	@Override
	public boolean delete(String hashKey, String rangeKey) {
		return LectureRepository.getInstance().delete(hashKey, rangeKey);
	}

	/*
	 * @Override public Lecture retrieveById(String hashKey, String rangeKey) {
	 * return LectureRepository.getInstance().retrieveById(hashKey, rangeKey); }
	 * 
	 * @Override public ArrayList<Lecture> retrieveAll() { return
	 * LectureRepository.getInstance().retrieveAll(); }
	 */

	@Override
	public boolean containLectureBelongFaculty(String facultyId) {
		return LectureRepository.getInstance().containLectureBelongFaculty(facultyId);
	}
}
