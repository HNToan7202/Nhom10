package vn.iotstar.servicesImpl;



import vn.iotstar.Entity.Subject;
import vn.iotstar.repositoryImpl.SubjectRepository;
import vn.iotstar.services.ISubjectService;

import java.util.ArrayList;

public class SubjectServiceImpl implements ISubjectService{
    private static SubjectServiceImpl instance = null;
    public static SubjectServiceImpl getInstance(){
        if(instance == null)
            instance = new SubjectServiceImpl();
        return instance;
    }

    @Override
    public boolean insert(Subject request) {
        return SubjectRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(Subject request) {
        return SubjectRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return SubjectRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public Subject retrieveById(String hashKey, String rangeKey) {
        return SubjectRepository.getInstance().retrieveById(hashKey, rangeKey);
    }

    @Override
    public ArrayList<Subject> retrieveAll() {
        return SubjectRepository.getInstance().retrieveAll();
    }
}
