package com.loopme.task.adminapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loopme.task.adminapp.entity.app.App;

/**
 * Created by Artem Karpov
 */
public interface ApplicationDAO extends JpaRepository<App, Integer> {
	Optional<App> findByName(String name);
	Optional<App> findByType(String name);
}