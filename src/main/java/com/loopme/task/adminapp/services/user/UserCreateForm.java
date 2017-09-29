package com.loopme.task.adminapp.services.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.loopme.task.adminapp.entity.user.UserRole;

/**
 * Created by Artem Karpov
 */
public class UserCreateForm {

	@NotEmpty
	private String email = "";

	@NotEmpty
	private String username = "";

	@NotEmpty
	private String password = "";

	@NotNull
	private UserRole role = UserRole.ADOPS;

	@NotNull
	private boolean enabled = false;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


}
