package com.loopme.task.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loopme.task.adminapp.entity.app.App;

/**
 * Created by Artem Karpov
 */
public interface ApplicationDAO extends JpaRepository<App, Integer> {
}