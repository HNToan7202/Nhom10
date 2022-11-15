package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.StudentClass;

public interface IStudentClassRepository  {
    boolean containFaculty(String facultyId);

	boolean insert(StudentClass request);

	boolean update(StudentClass request);

	boolean delete(String hashKey, String rangeKey);

	StudentClass retrieveById(String hashKey, String rangeKey);

	ArrayList<StudentClass> retrieveAll();
}
