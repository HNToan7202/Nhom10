package vn.iotstar.services;

import java.util.ArrayList;

import vn.iotstar.Entity.Lecture;

public interface ILectureService {
	boolean insert(Lecture request);

	boolean update(Lecture request);

	boolean delete(String hashKey, String rangeKey);

	/*
	 * Lecture retrieveById(String hashKey, String rangeKey);
	 * 
	 * ArrayList<Lecture> retrieveAll();
	 */

	boolean containLectureBelongFaculty(String facultyId);
}
