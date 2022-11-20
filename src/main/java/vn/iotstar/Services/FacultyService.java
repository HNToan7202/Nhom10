package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.Grade;


public interface FacultyService {

	/**
	 * @param studentId
	 * @param grade
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#updateFaculty(java.lang.String,
	 *      vn.iotstar.Entity.Grade)
	 */
	String updateFaculty(String studentId, Grade grade);

	/**
	 * @param studentId
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#deleteFacultyById(java.lang.String)
	 */
	String deleteFacultyById(String studentId);

	/**
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#findAll()
	 */
	List<Faculty> findAll();

	/**
	 * @param facultyId
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#getFacultyId(java.lang.String)
	 */
	Faculty getFacultyId(String facultyId);

	/**
	 * @param faculty
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#saveFaculty(vn.iotstar.Entity.Faculty)
	 */
	Faculty saveFaculty(Faculty faculty);

}
