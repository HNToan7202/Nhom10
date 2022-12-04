package vn.iotstar.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.Entity.User;
import vn.iotstar.Reponsitories.IUserRepository;
import vn.iotstar.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepo;

	@Override
	public <S extends User> S save(S entity) {
		return userRepo.save(entity);
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		return userRepo.saveAll(entities);
	}

	@Override
	public Optional<User> findById(String id) {
		return userRepo.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return userRepo.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public Iterable<User> findAllById(Iterable<String> ids) {
		return userRepo.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepo.count();
	}

	@Override
	public void deleteById(String id) {
		userRepo.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRepo.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		userRepo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		userRepo.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		userRepo.deleteAll();
	}

	@Override
	public Iterable<User> findByUsernameContaining(String username) {
		return userRepo.findByUsernameContaining(username);
	}

	@Override
	public List<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		List<User> optExist = findByUsername(username);

		if (optExist.size() > 0 && optExist.get(0).getPassword().equals(password)) {
			return optExist.get(0);
		}
		return null;
	}

}
