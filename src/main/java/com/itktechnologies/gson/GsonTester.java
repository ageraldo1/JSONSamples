package com.itktechnologies.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTester {

	public static void main(String[] args) {
		String json = "{'name': 'Alexandre Geraldo','age': 39}";
		
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		Gson gson = builder.create();
		
		Student student = gson.fromJson(json, Student.class);
		System.out.println(student);
		System.out.print("\n\n");
		
		System.out.println(gson.toJson(student));
		
		System.out.print("\n\n");
		
		GsonFileTester gsonFileTester = new GsonFileTester();
		
		gsonFileTester.writeJSON(student);
		Student theStudent = gsonFileTester.readJSON();
		
		System.out.println(theStudent);
		
		System.out.print("\n\n");
		
		System.out.println("Serialization...");
		gsonFileTester.serialize();
		System.out.println("\n\n");
		
		System.out.println("Deserialization...");
		gsonFileTester.deserialize();
		System.out.println("\n\n");

		System.out.println("Tree Model...");
		gsonFileTester.tree();
		System.out.println("\n\n");

		
		
	}

}
