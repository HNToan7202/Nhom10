package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Student;

@Repository
@EnableScan
public interface IStudentRepository extends CrudRepository<Student, String> {
	Iterable<Student> findByNameContaining(String name);
}
