package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.Lecture;

public interface ILectureRepository  {
    boolean containLectureBelongFaculty(String facultyId);

	boolean insert(Lecture request);

	boolean update(Lecture request);

	boolean delete(String hashKey, String rangeKey);

	/*
	 * Lecture retrieveById(String hashKey, String rangeKey);
	 * 
	 * ArrayList<Lecture> retrieveAll();
	 */
}
