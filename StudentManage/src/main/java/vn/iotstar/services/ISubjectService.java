package vn.iotstar.services;

import vn.iotstar.Entity.Subject;

import java.util.ArrayList;

public interface ISubjectService {
    boolean insert(Subject request);
    boolean update(Subject request);
    boolean delete(String hashKey, String rangeKey);
    Subject retrieveById(String hashKey, String rangeKey);
    ArrayList<Subject> retrieveAll();
}
