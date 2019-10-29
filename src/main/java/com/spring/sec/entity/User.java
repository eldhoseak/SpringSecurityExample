package com.spring.sec.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String userName;
	@Column(name = "PASSWORD")
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
