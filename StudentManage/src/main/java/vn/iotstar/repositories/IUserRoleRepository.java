package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.UserRole;



public interface IUserRoleRepository {
	
    boolean insert(UserRole request);
    
    boolean update(UserRole request);
    
    boolean delete(String hashKey, String rangeKey);
    
    
    
    UserRole retrieveById(String hashKey, String rangeKey);
    
    ArrayList<UserRole> retrieveAll();
    
    boolean containRole(String roleId);
    
    boolean containUser(String username);
}
