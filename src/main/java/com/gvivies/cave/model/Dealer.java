package com.gvivies.cave.model;

import org.springframework.data.annotation.Id;

public class Dealer {

	@Id
	private String _id;	
	private String name;
	private String street;
	private String zipCode;
	private String city;
	private String telephone;
	private String email;
	private String webSite;
	private String comment;
	private String latitude;
	private String longitude;
	private Region region;
	
	public Dealer() {}

	public Dealer(String name, String street, String zipCode, String city, String telephone, String email,
			String webSite, String comment, String latitude, String longitude, Region region) {
		super();
		this.name = name;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.telephone = telephone;
		this.email = email;
		this.webSite = webSite;
		this.comment = comment;
		this.latitude = latitude;
		this.longitude = longitude;
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
	public final String getStreet() {
		return street;
	}
	public final void setStreet(String street) {
		this.street = street;
	}
	public final String getZipCode() {
		return zipCode;
	}
	public final void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	public final String getTelephone() {
		return telephone;
	}
	public final void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getWebSite() {
		return webSite;
	}
	public final void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public final String getComment() {
		return comment;
	}
	public final void setComment(String comment) {
		this.comment = comment;
	}
	public final String getLatitude() {
		return latitude;
	}
	public final void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public final String getLongitude() {
		return longitude;
	}
	public final void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public final Region getRegion() {
		return region;
	}

	public final void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Dealer [name=" + name + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + "]";
	}	
	
}
