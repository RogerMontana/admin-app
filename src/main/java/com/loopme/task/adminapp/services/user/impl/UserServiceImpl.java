package com.loopme.task.adminapp.services.user.impl;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

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
	public Optional<User> getByUsername(String name) {
		return userRepository.findByUsername(name);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("username"));
	}

	@Override
	@Transactional
	public User create(UserCreateForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
		user.setEmail(form.getEmail());
		user.setEnabled(form.isEnabled());
		user.setRole(form.getRole());
		return userRepository.save(user);
	}


}

