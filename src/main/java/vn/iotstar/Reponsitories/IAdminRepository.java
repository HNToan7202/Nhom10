package vn.iotstar.Reponsitories;

import java.util.List;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Admin;

@Repository
@EnableScan
public interface IAdminRepository extends CrudRepository<Admin, String> {
	List<Admin> findByUsername(String username);

	Iterable<Admin> findByNameContaining(String name);
}
