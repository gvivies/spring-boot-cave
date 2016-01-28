package com.gvivies.cave.model;

public enum Containing {
	BOUTEILLE("Bouteille"),
	DEMI_BOUTEILLE("Demi-bouteille"),
	MAGNUM("Magnum");
	
	private String value;
	
	Containing(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
