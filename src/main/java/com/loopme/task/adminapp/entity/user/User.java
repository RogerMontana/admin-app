package com.loopme.task.adminapp.entity.user;

/**
 * Created by Artem Karpov
 */

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.loopme.task.adminapp.entity.app.App;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true, insertable = false)
	private Integer id;

	@Column(name = "NAME", nullable = false, unique = true)
	private String name;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ROLE", nullable = false, length = 30)
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<App> products;

	//TODO WTF IS THAT
	@PrePersist
	public void prePersist() {
		if (role == null) {
			role = UserRole.PUBLISHER;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<App> getProducts() {
		return products;
	}

	public void setProducts(List<App> products) {
		this.products = products;
	}
}


