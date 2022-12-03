package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Subject;

@Repository
@EnableScan
public interface ISubjectRepository extends CrudRepository<Subject, String> {
	Iterable<Subject> findByNameContaining(String name);
}
