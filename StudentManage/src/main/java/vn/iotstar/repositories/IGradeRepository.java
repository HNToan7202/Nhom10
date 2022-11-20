package vn.iotstar.repositories;


import java.util.ArrayList;

import vn.iotstar.Entity.Grade;

public interface IGradeRepository  {
    boolean containStudent(String studentId);
    boolean containSubjectGroup(String subjectGroupId);

	/* ArrayList<Grade> retrieveGradeByLectureId(String lectureId); */
}
