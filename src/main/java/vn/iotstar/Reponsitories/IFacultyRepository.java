package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Faculty;

@Repository
@EnableScan
public interface IFacultyRepository extends CrudRepository<Faculty, String> {
	Iterable<Faculty> findByNameContaining(String name);
}
