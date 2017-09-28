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
	private String password = "";

	@NotEmpty
	private String passwordRepeated = "";

	@NotNull
	private UserRole role = UserRole.ADOPS;

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

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}
