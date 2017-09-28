package com.loopme.task.adminapp.services.user.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loopme.task.adminapp.dao.UserDAO;
import com.loopme.task.adminapp.entity.user.User;
import com.loopme.task.adminapp.services.user.UserCreateForm;
import com.loopme.task.adminapp.services.user.UserService;

/**
 * Created by Artem Karpov
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userRepository;

	@Autowired
	public UserServiceImpl(UserDAO userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Optional<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setEmail(form.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setRole(form.getRole());
		return userRepository.save(user);
	}


}

