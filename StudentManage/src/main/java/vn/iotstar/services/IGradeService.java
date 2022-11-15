package vn.iotstar.services;

import java.util.ArrayList;

import vn.iotstar.Entity.Grade;

public interface IGradeService {
	boolean insert(Grade request);

	boolean update(Grade request);

	boolean delete(String hashKey, String rangeKey);

	Grade retrieveById(String hashKey, String rangeKey);

	ArrayList<Grade> retrieveAll();

	boolean containStudent(String studentId);

	boolean containSubjectGroup(String subjectGroupId);

	ArrayList<Grade> retrieveGradeByLectureId(String lectureId);
}
