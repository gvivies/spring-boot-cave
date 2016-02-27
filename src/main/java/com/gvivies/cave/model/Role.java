package com.gvivies.cave.model;

public enum Role {
    USER("USER","Utilisateur"), ADMIN("ADMIN", "Administrateur");
	
	private String id;
	private String roledesc;
	
	Role(String id, String roledesc) {
		this.id = id;
		this.roledesc = roledesc;
	}
	
	public final String getId() {
		return id;
	}
	
	public final String getRoledesc() {
		return roledesc;
	}
}

