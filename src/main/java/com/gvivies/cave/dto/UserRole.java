package com.gvivies.cave.dto;

import java.io.Serializable;

public class UserRole implements Serializable{

	private static final long serialVersionUID = -3553349275420469687L;
	
	private String id;
	private String roleName;

	public UserRole(String id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
	public final String getId() {
		return id;
	}

	public final String getRoleName() {
		return roleName;
	} 
}
