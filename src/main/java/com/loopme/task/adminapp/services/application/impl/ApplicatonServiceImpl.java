package com.loopme.task.adminapp.services.application.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.loopme.task.adminapp.dao.ApplicationDAO;
import com.loopme.task.adminapp.entity.app.App;
import com.loopme.task.adminapp.services.application.AppCreateForm;
import com.loopme.task.adminapp.services.application.ApplicationService;

/**
 * (c) Swissquote
 * Created by Artem Karpov
 */
public class ApplicatonServiceImpl implements ApplicationService {

	private final ApplicationDAO applicationDAO;

	@Autowired
	public ApplicatonServiceImpl(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}

	@Override
	public Optional<App> getAppByName(String name) {
		return applicationDAO.findByName(name);
	}

	@Override
	public Optional<App> getAppByType(String type) {
		return applicationDAO.findByType(type);
	}

	@Override
	public App create(AppCreateForm form) {
		App app = new App();
		app.setName(form.getName());
		app.setType(form.getType());
		return applicationDAO.save(app);
	}
}
