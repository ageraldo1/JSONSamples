package com.itktechnologies.gson;

import java.util.List;

public class Bakery {
	
	private String name;
	private List<MenuItem> item;
	
	public Bakery(String name, List<MenuItem> item) {
		super();
		this.name = name;
		this.item = item;
	}

	@Override
	public String toString() {
		return "Bakery [name=" + name + ", item=" + item + "]";
	}

}
