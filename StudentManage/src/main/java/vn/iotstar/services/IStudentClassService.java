package vn.iotstar.services;

import java.util.ArrayList;

import vn.iotstar.Entity.StudentClass;

public interface IStudentClassService {
	boolean insert(StudentClass request);

	boolean update(StudentClass request);

	boolean delete(String hashKey, String rangeKey);

	StudentClass retrieveById(String hashKey, String rangeKey);

	ArrayList<StudentClass> retrieveAll();

	boolean containFaculty(String facultyId);

}
