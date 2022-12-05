package vn.iotstar.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Model.AdminModel;
@Component
public interface IAdminService {

	void deleteAll();

	void deleteAll(Iterable<? extends Admin> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Admin entity);

	void deleteById(String id);

	long count();

	Iterable<Admin> findAllById(Iterable<String> ids);

	List<AdminModel> retreiveAll();

	boolean existsById(String id);

	Optional<Admin> findById(String id);

	<S extends Admin> Iterable<S> saveAll(Iterable<S> entities);

	<S extends Admin> S save(S entity);

	List<Admin> findByUsername(String username);

	Iterable<Admin> findByNameContaining(String name);

	Iterable<Admin> findAll();
}
