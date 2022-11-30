package vn.iotstar.Service;

import java.util.List;

import vn.iotstar.Entity.Faculty;

public interface IFacultyService {

	String updateFaculty(String facultyId, Faculty faculty);

	String deleteFacultyById(String facultyId);

	List<Faculty> findAll();

	Faculty getFacultyId(String facultyId);

	Faculty saveFaculty(Faculty faculty);

}
