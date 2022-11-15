package vn.iotstar.servicesImpl;

import vn.iotstar.Entity.Role;
import vn.iotstar.repositoryImpl.RoleRepository;
import vn.iotstar.services.IRoleService;

import java.util.ArrayList;

public class RoleServiceImpl implements IRoleService{
    private static RoleServiceImpl instance = null;
    public static RoleServiceImpl getInstance(){
        if(instance == null)
            instance = new RoleServiceImpl();
        return instance;
    }

    @Override
    public boolean insert(Role request) {
        return RoleRepository.getInstance().insert(request);
    }

    @Override
    public boolean update(Role request) {
        return RoleRepository.getInstance().update(request);
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return RoleRepository.getInstance().delete(hashKey, rangeKey);
    }

    @Override
    public Role retrieveById(String hashKey, String rangeKey) {
        return RoleRepository.getInstance().retrieveById(hashKey, rangeKey);
    }

    @Override
    public ArrayList<Role> retrieveAll() {
        return RoleRepository.getInstance().retrieveAll();
    }
}
