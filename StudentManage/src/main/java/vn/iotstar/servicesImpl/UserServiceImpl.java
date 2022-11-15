package vn.iotstar.servicesImpl;

import vn.iotstar.Entity.User;
import vn.iotstar.repositoryImpl.UserRepository;
import vn.iotstar.services.IUserService;

import java.util.ArrayList;

public class UserServiceImpl implements IUserService{
    private static UserServiceImpl instance = null;
    public static UserServiceImpl getInstance(){
        if(instance == null)
            instance = new UserServiceImpl();
        return instance;
    }

    @Override
    public boolean insert(User request) {
        return UserRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(User request) {
        return UserRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return UserRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public User retrieveById(String hashKey, String rangeKey) {
        return UserRepository.getInstance().retrieveById(hashKey, rangeKey);
    }

    @Override
    public ArrayList<User> retrieveAll() {
        return UserRepository.getInstance().retrieveAll();
    }

    @Override
    public boolean login(String username, String password) {
        return UserRepository.getInstance().login(username, password);
    }
}
