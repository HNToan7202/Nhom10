package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.StudentClass;

@Repository
@EnableScan
public interface IStudentClassRepository extends CrudRepository<StudentClass, String> {
	Iterable<StudentClass> findByNameContaining(String name);
}
