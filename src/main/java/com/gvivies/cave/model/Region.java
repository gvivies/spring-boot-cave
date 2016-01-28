package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;

public class Region {

	@Id
	private String id;
    private String name;
    
    public Region() {}

	public Region(String name) {
		super();
		this.name = name;
	}

	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Region [name=" + name + "]";
	}
}
