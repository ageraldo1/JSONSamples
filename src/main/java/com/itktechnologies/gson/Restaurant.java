package com.itktechnologies.gson;

public class Restaurant {
	private String name;
	private RestaurantOwner owner;
	private RestaurantStaff cook;
	private RestaurantStaff waiter;
	
	private class RestaurantOwner {
		private String name;
		private UserAddress address;
		
		@Override
		public String toString() {
			return "RestaurantOwner [name=" + name + ", address=" + address + "]";
		}
	}
	
	private class RestaurantStaff {
		private String name;
		private int age;
		private int salary;
		
		@Override
		public String toString() {
			return "RestaurantStaff [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
		
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", owner=" + owner + ", cook=" + cook + ", waiter=" + waiter + "]";
	}
	

}
