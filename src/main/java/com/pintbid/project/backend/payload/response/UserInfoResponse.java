package com.pintbid.project.backend.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Boolean isBlocked;
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private List<String> roles;

	public UserInfoResponse(Integer id,Boolean isBlocked, String firstname, String lastname, String username, String email, List<String> roles) {
		this.id = id;
		this.isBlocked = isBlocked;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<String> getRoles() {
		return roles;
	}
}
