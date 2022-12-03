package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Faculty;
import vn.iotstar.Entity.Grade;

@Repository
@EnableScan
public interface IGradeRepository extends CrudRepository<Grade, String> {
	Iterable<Grade> findBySubjectIdContaining(String subjectId);
	Iterable<Grade> findByMssvContaining(Integer MSSV);
}
