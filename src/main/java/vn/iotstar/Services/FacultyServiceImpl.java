package vn.iotstar.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.Grade;
import vn.iotstar.Reponsitories.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyrepository;

	/**
	 * @param faculty
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#saveFaculty(vn.iotstar.Entity.Faculty)
	 */
	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyrepository.saveFaculty(faculty);
	}

	/**
	 * @param facultyId
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#getFacultyId(java.lang.String)
	 */
	@Override
	public Faculty getFacultyId(String facultyId) {
		return facultyrepository.getFacultyId(facultyId);
	}

	/**
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#findAll()
	 */
	@Override
	public List<Faculty> findAll() {
		return facultyrepository.findAll();
	}

	/**
	 * @param studentId
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#deleteFacultyById(java.lang.String)
	 */
	@Override
	public String deleteFacultyById(String studentId) {
		return facultyrepository.deleteFacultyById(studentId);
	}

	/**
	 * @param studentId
	 * @param grade
	 * @return
	 * @see vn.iotstar.Reponsitories.FacultyRepository#updateFaculty(java.lang.String,
	 *      vn.iotstar.Entity.Grade)
	 */
	@Override
	public String updateFaculty(String studentId, Grade grade) {
		return facultyrepository.updateFaculty(studentId, grade);
	}

}
