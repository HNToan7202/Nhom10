package vn.iotstar.servicesImpl;


import vn.iotstar.Entity.StudentClass;
import vn.iotstar.repositoryImpl.StudentClassRepository;
import vn.iotstar.services.IStudentClassService;

import java.util.ArrayList;

public class StudentClassServiceImpl implements IStudentClassService{
    private static StudentClassServiceImpl instance = null;
    public static StudentClassServiceImpl getInstance(){
        if(instance == null)
            instance = new StudentClassServiceImpl();
        return instance;
    }

    @Override
    public boolean insert(StudentClass request) {
        return StudentClassRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(StudentClass request) {
        return StudentClassRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return StudentClassRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public StudentClass retrieveById(String hashKey, String rangeKey) {
        return StudentClassRepository.getInstance().retrieveById(hashKey, rangeKey);
    }

    @Override
    public ArrayList<StudentClass> retrieveAll() {
        return StudentClassRepository.getInstance().retrieveAll();
    }

    @Override
    public boolean containFaculty(String facultyId) {
        return StudentClassRepository.getInstance().containFaculty(facultyId);
    }
}
