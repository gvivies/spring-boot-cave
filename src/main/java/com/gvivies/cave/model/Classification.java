package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;

public class Classification {
	
	@Id
	private String _id;
	private String name;

	public Classification() {}
	
	public Classification(String name) {
		super();
		this.name = name;
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
	

}
