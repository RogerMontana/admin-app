package com.loopme.task.adminapp.services.application;

import org.hibernate.validator.constraints.NotEmpty;

import com.loopme.task.adminapp.entity.app.AppType;

/**
 * (c) Swissquote
 * Created by Artem Karpov
 */
public class AppCreateForm {
	@NotEmpty
	private String name = "";

	@NotEmpty
	private AppType type = AppType.WEBSITE;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppType getType() {
		return type;
	}

	public void setType(AppType type) {
		this.type = type;
	}



}
