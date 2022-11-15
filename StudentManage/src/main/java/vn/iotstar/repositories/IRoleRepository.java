package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.Role;

public interface IRoleRepository  {

	boolean insert(Role request);

	boolean update(Role request);

	boolean delete(String hashKey, String rangeKey);

	Role retrieveById(String hashKey, String rangeKey);

	ArrayList<Role> retrieveAll();
}
