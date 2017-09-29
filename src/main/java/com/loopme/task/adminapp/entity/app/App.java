package com.loopme.task.adminapp.entity.app;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.loopme.task.adminapp.entity.user.User;
import com.loopme.task.adminapp.entity.content.ContentType;

/**
 * Created by Artem Karpov
 */
@Entity
@Table(name = "APPLICATIONS")
public class App {
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false, unique = true, insertable = false)
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "TYPE", nullable = false, length = 30)
	@Enumerated(EnumType.STRING)
	private AppType type;

	@ElementCollection(targetClass = ContentType.class)
	@CollectionTable(name = "ContentDAO", joinColumns = @JoinColumn(name = "ID"))
	@Column(name = "CONTENT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private List<ContentType> contentTypes;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

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

	public AppType getType() {
		return type;
	}

	public void setType(AppType type) {
		this.type = type;
	}

	public List<ContentType> getContentTypes() {
		return contentTypes;
	}

	public void setContentTypes(List<ContentType> contentTypes) {
		this.contentTypes = contentTypes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}