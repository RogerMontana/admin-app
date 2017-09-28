package com.loopme.task.adminapp.services.user;

import java.util.Collection;
import java.util.Optional;

import com.loopme.task.adminapp.entity.user.User;

/**
 * (c) Swissquote
 * Created by Artem Karpov
 */
public interface UserService {

	Optional<User> getUserById(int id);

	Optional<User> getUserByEmail(String email);

	Optional<User> getUserByName(String email);

	Collection<User> getAllUsers();

	User create(UserCreateForm form);

}
