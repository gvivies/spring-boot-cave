package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String _id;
	private String username = "";
    private String email = "";
    private String password = "";
    private String passwordRepeated = "";
    private Role role;
    private String passwordHash;

	public final Role getRole() {
		return role;
	}

	public final void setRole(Role role) {
		this.role = role;
	}

	public final String getPasswordHash() {
		return passwordHash;
	}

	public final void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getPasswordRepeated() {
		return passwordRepeated;
	}

	public final void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

}
