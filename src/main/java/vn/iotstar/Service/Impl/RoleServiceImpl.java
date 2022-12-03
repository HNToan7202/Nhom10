package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Role;
import vn.iotstar.Reponsitories.IRoleRepository;
import vn.iotstar.Service.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleRepository roleRepo;

	@Override
	public Iterable<Role> findByNameContaining(String name) {
		return roleRepo.findByNameContaining(name);
	}

	@Override
	public <S extends Role> S save(S entity) {
		return roleRepo.save(entity);
	}

	@Override
	public <S extends Role> Iterable<S> saveAll(Iterable<S> entities) {
		return roleRepo.saveAll(entities);
	}

	@Override
	public Optional<Role> findById(String id) {
		return roleRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return roleRepo.existsById(id);
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepo.findAll();
	}

	@Override
	public Iterable<Role> findAllById(Iterable<String> ids) {
		return roleRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return roleRepo.count();
	}

	@Override
	public void deleteById(String id) {
		roleRepo.deleteById(id);
	}

	@Override
	public void delete(Role entity) {
		roleRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		roleRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		roleRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		roleRepo.deleteAll();
	}
	
}
