package com.gvivies.cave.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Region {

	@Id
	private String id;
    private String name;
    @Transient
    private int quantity;

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
    public final int getQuantity() {
		return quantity;
	}
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Region [name=" + name + "]";
	}
	
}
