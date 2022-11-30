package vn.iotstar.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Reponsitories.FacultyRepository;
import vn.iotstar.Service.IFacultyService;

@Service
public class FacultyServiceImpl implements IFacultyService{

	@Autowired
	FacultyRepository facultyRepo;

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepo.saveFaculty(faculty);
	}

	@Override
	public Faculty getFacultyId(String facultyId) {
		return facultyRepo.getFacultyId(facultyId);
	}

	@Override
	public List<Faculty> findAll() {
		return facultyRepo.findAll();
	}

	@Override
	public String deleteFacultyById(String facultyId) {
		return facultyRepo.deleteFacultyById(facultyId);
	}

	@Override
	public String updateFaculty(String facultyId, Faculty faculty) {
		return facultyRepo.updateFaculty(facultyId, faculty);
	}
	
	
}
