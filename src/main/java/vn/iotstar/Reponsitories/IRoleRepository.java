package vn.iotstar.Reponsitories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Role;


@Repository
@EnableScan
public interface IRoleRepository extends CrudRepository<Role, String> {
	Iterable<Role> findByNameContaining(String name);
}
