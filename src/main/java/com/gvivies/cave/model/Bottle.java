package com.gvivies.cave.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Bottle extends Possessor {
	
	@Id
	private String _id;
	private String name;
	private Dealer dealer;
	private Wine wine;
	private Classification classification;
	private int year;
	private int yearMin;
	private int yearMax;
	private int quantity;
	private Date purchaseDate;
	private double price;
	private String comment;
	private Containing containing;
	private boolean ordered;
	
	public Bottle() {}
	
	public Bottle(String name, Dealer dealer, Wine wine, Classification classification, int year, int yearMin,
			int yearMax, int quantity, Date purchaseDate, double price, String comment, Containing containing, String ownedBy) {
		super();
		this.name = name;
		this.dealer = dealer;
		this.wine = wine;
		this.classification = classification;
		this.year = year;
		this.yearMin = yearMin;
		this.yearMax = yearMax;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.comment = comment;
		this.containing = containing;
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
	public final Dealer getDealer() {
		return dealer;
	}
	public final void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	public final Wine getWine() {
		return wine;
	}
	public final void setWine(Wine wine) {
		this.wine = wine;
	}
	public final Classification getClassification() {
		return classification;
	}
	public final void setClassification(Classification classification) {
		this.classification = classification;
	}
	public final int getYear() {
		return year;
	}
	public final void setYear(int year) {
		this.year = year;
	}
	public final int getYearMin() {
		return yearMin;
	}
	public final void setYearMin(int yearMin) {
		this.yearMin = yearMin;
	}
	public final int getYearMax() {
		return yearMax;
	}
	public final void setYearMax(int yearMax) {
		this.yearMax = yearMax;
	}
	public final int getQuantity() {
		return quantity;
	}
	public final void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public final Date getPurchaseDate() {
		return purchaseDate;
	}
	public final void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public final String getComment() {
		return comment;
	}
	public final void setComment(String comment) {
		this.comment = comment;
	}
	public final Containing getContaining() {
		return containing;
	}
	public final void setContaining(Containing containing) {
		this.containing = containing;
	}
	public final boolean isOrdered() {
		return ordered;
	}

	public final void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	@Override
	public String toString() {
        return String.format("Customer[id=%s, name='%s']", _id, name);	
	}
}
