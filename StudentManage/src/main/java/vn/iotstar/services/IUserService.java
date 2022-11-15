package vn.iotstar.services;

import vn.iotstar.Entity.User;

import java.util.ArrayList;

public interface IUserService {
	boolean insert(User request);

	boolean update(User request);

	boolean delete(String hashKey, String rangeKey);

	User retrieveById(String hashKey, String rangeKey);

	ArrayList<User> retrieveAll();

	boolean login(String username, String password);
}
