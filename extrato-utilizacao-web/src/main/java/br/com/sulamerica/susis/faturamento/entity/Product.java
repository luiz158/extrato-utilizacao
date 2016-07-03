package br.com.sulamerica.susis.faturamento.entity;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = -4562321368526526225L;

	private String productID;
	private String name;
	private String model;
	private int code;
	private float price;
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
