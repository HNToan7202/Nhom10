package vn.iotstar.services;

import java.util.ArrayList;

import vn.iotstar.Entity.Faculty;

public interface IFacultyService {
	public boolean insert(Faculty request);

	public boolean update(Faculty request);

	public boolean delete(String hashKey, String rangeKey);

	public Faculty retrieveById(String hashKey, String rangeKey);

	public ArrayList<Faculty> retrieveAll();
}
