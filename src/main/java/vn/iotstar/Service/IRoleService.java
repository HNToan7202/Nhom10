package vn.iotstar.Service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import vn.iotstar.Entity.Role;
@Component
public interface IRoleService {

	void deleteAll();

	void deleteAll(Iterable<? extends Role> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Role entity);

	void deleteById(String id);

	long count();

	Iterable<Role> findAllById(Iterable<String> ids);

	Iterable<Role> findAll();

	boolean existsById(String id);

	Optional<Role> findById(String id);

	<S extends Role> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Role> S save(S entity);

	Iterable<Role> findByNameContaining(String name);

}
