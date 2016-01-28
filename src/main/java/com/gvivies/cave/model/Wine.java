package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;

public class Wine {
	
	@Id
	private String _id;
	private String name;
	private Region region;

	public Wine() {}
	
	public Wine(String name, Region region) {
		super();
		this.name = name;
		this.region = region;
	}

	public final String getId() {
		return _id;
	}
	public final void setId(String id) {
		this._id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Region getRegion() {
		return region;
	}
	public final void setRegion(Region region) {
		this.region = region;
	}	
	@Override
	public String toString() {
		return "Wine [name=" + name + ", region=" + region + "]";
	}	
}
