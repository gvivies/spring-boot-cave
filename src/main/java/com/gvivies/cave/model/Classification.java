package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Classification extends Possessor {
	
	@Id
	private String _id;
	private String name;
    @Transient
    private int quantity;

	public Classification() {}
	
	public Classification(String name, String ownedBy) {
		super();
		this.name = name;
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

	public final int getQuantity() {
		return quantity;
	}

	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
