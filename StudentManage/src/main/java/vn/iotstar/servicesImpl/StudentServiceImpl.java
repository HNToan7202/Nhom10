package vn.iotstar.servicesImpl;


import vn.iotstar.Entity.Student;
import vn.iotstar.repositoryImpl.StudentRepository;
import vn.iotstar.services.IStudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements IStudentService{
    private static StudentServiceImpl instance = null;
    public static StudentServiceImpl getInstance(){
        if(instance == null)
            instance = new StudentServiceImpl();
        return instance;
    }

    @Override
    public boolean insert(Student request) {
        return StudentRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(Student request) {
        return StudentRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return StudentRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public Student retrieveById(String hashKey, String rangeKey) {
        return StudentRepository.getInstance().retrieveById(hashKey, rangeKey);
    }

    @Override
    public ArrayList<Student> retrieveAll() {
        return StudentRepository.getInstance().retrieveAll();
    }

    @Override
    public boolean containStudentClass(String studentClassId) {
        return StudentRepository.getInstance().containStudentClass(studentClassId);
    }
}
