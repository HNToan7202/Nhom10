package vn.iotstar.repositories;

import java.util.ArrayList;

import vn.iotstar.Entity.SubjectGroup;


public interface ISubjectGroupRepository {
	
    boolean insert(SubjectGroup request);
    boolean update(SubjectGroup request);
    boolean delete(String hashKey, String rangeKey);
    SubjectGroup retrieveById(String hashKey, String rangeKey);
    ArrayList<SubjectGroup> retrieveAll();
    boolean containLecture(String lectureId);
    boolean containSubject(String subjectId);
    ArrayList<SubjectGroup> retrieveSubjectGroupByLectureId(String lectureId);

}
