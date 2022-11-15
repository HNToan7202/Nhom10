package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.Student;

public interface IStudentRepository  {
    boolean containStudentClass(String studentClassId);

	boolean insert(Student request);

	boolean update(Student request);

	boolean delete(String hashKey, String rangeKey);

	ArrayList<Student> retrieveAll();

	Student retrieveById(String hashKey, String rangeKey);
}
