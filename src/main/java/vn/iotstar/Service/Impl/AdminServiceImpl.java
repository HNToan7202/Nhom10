package vn.iotstar.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.Admin;
import vn.iotstar.Reponsitories.IAdminRepository;
import vn.iotstar.Service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	IAdminRepository adminRepo;

	@Override
	public <S extends Admin> S save(S entity) {
		return adminRepo.save(entity);
	}

	@Override
	public <S extends Admin> Iterable<S> saveAll(Iterable<S> entities) {
		return adminRepo.saveAll(entities);
	}

	@Override
	public Optional<Admin> findById(String id) {
		return adminRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return adminRepo.existsById(id);
	}

	@Override
	public Iterable<Admin> findAll() {
		return adminRepo.findAll();
	}

	@Override
	public Iterable<Admin> findAllById(Iterable<String> ids) {
		return adminRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return adminRepo.count();
	}

	@Override
	public void deleteById(String id) {
		adminRepo.deleteById(id);
	}

	@Override
	public void delete(Admin entity) {
		adminRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		adminRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Admin> entities) {
		adminRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		adminRepo.deleteAll();
	}
	
}
