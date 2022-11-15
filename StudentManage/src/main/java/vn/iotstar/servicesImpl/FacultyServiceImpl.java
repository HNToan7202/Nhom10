package vn.iotstar.servicesImpl;

import java.util.ArrayList;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.repositoryImpl.FacultyRepository;
import vn.iotstar.services.IFacultyService;

public class FacultyServiceImpl implements IFacultyService {
	
	private static FacultyServiceImpl instance = null;
    public static FacultyServiceImpl getInstance(){
        if(instance == null)
            instance = new FacultyServiceImpl();
        return instance;
    }
    @Override
    public boolean insert(Faculty request) {
        return FacultyRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(Faculty request) {
        return FacultyRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return FacultyRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public Faculty retrieveById(String hashKey, String rangeKey) {
        return FacultyRepository.getInstance().retrieveById(hashKey,rangeKey);
    }

    @Override
    public ArrayList<Faculty> retrieveAll() {
        return FacultyRepository.getInstance().retrieveAll();
    }
}
