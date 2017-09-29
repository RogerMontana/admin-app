package com.loopme.task.adminapp.services.application;

import java.util.Optional;

import com.loopme.task.adminapp.entity.app.App;

/**
 * (c) Swissquote
 * Created by Artem Karpov
 */
public interface ApplicationService {
	Optional<App> getAppByName(String name);

	Optional<App> getAppByType(String type);

	App create(AppCreateForm form);
}
