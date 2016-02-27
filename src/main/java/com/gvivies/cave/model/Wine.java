package com.gvivies.cave.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Wine extends Possessor {
	
	@Id
	private String _id;
	private String name;
	private Region region;
	@Transient
	private int quantity;

	public Wine() {}
	
	public Wine(String name, Region region, String ownedBy) {
		super();
		this.name = name;
		this.region = region;
		this.ownedBy = ownedBy;
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
	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Wine [name=" + name + ", region=" + region + "]";
	}	
}
