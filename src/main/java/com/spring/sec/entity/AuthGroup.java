package com.spring.sec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthGroup {

	@Id
	@Column(name = "AUTH_USER_GROUP_ID")
	private Long id;
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String userName;
	@Column(name = "AUTH_GROUP")
	private String authGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthGroup() {
		return authGroup;
	}

	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}
}
