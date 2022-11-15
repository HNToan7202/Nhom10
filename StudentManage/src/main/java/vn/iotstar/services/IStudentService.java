package vn.iotstar.services;

import vn.iotstar.Entity.Student;

import java.util.ArrayList;

public interface IStudentService {
	boolean insert(Student request);

	boolean update(Student request);

	boolean delete(String hashKey, String rangeKey);

	Student retrieveById(String hashKey, String rangeKey);

	ArrayList<Student> retrieveAll();

	boolean containStudentClass(String studentClassId);
}
