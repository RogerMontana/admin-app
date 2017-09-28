package com.loopme.task.adminapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.loopme.task.adminapp.entity.user.User;
import com.loopme.task.adminapp.entity.user.UserRole;

/**
 * (c) Swissquote
 * Created by Artem Karpov
 */
public interface UserDAO extends JpaRepository<User, Integer> {

	Optional<User> findOneByEmail(String email);

	Optional<User> findByName(String name);

	@Query(value = "select u from User u where u.role < :role")
	List<User> findUsersByRole(@Param("role") UserRole role);
}