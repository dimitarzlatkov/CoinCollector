package com.dimitar.zlatkov.eurocoincollector.db.bean;

public class Coin {

	private int id;
	private int facialValue;
	private double coinValue;
	private String imageUrl;
	private String description;
	private String shape;
	private double weight;
	private double diameter;
	private String thickness;
	private boolean commemorative;
	private boolean haveIt;
	private String currencyType;
	private String memo;
	private Country country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacialValue() {
		return facialValue;
	}

	public void setFacialValue(int facialValue) {
		this.facialValue = facialValue;
	}

	public double getCoinValue() {
		return coinValue;
	}

	public void setCoinValue(double coinValue) {
		this.coinValue = coinValue;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public boolean isCommemorative() {
		return commemorative;
	}

	public void setCommemorative(boolean commemorative) {
		this.commemorative = commemorative;
	}

	public boolean isHaveIt() {
		return haveIt;
	}

	public void setHaveIt(boolean haveIt) {
		this.haveIt = haveIt;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
