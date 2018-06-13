package com.itktechnologies.gson;

public class MenuItem {

	private String name;
	private double price;
	
	
	public MenuItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}


	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", price=" + price + "]";
	}
	
}
