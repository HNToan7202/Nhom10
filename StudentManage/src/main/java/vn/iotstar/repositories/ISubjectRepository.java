package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.Subject;

public interface ISubjectRepository  {

	boolean insert(Subject request);

	boolean update(Subject request);

	boolean delete(String hashKey, String rangeKey);

	Subject retrieveById(String hashKey, String rangeKey);

	ArrayList<Subject> retrieveAll();

}
