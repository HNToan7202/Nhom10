package vn.iotstar.Reponsitories;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.User;

@Repository
@EnableScan
public interface IUserRepository extends CrudRepository<User, String> {
	Iterable<User> findByUsernameContaining(String username);
}
