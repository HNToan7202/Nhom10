package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.User;

public interface IUserRepository {
    boolean login(String username, String password);

	boolean insert(User request);

	boolean update(User request);

	boolean delete(String hashKey, String rangeKey);

	User retrieveById(String hashKey, String rangeKey);

	ArrayList<User> retrieveAll();
}
