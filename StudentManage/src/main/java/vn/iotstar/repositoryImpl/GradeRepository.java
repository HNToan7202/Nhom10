package vn.iotstar.repositoryImpl;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Grade;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@Repository
@EnableScan
public interface GradeRepository extends CrudRepository<Grade,String> {
	List<Grade> findBySubjectId(String subjectId);
	
	
}
