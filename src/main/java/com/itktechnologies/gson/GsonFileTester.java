package com.itktechnologies.gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class GsonFileTester {
	
	public void writeJSON(Student student) {
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting(); 
	    Gson gson = builder.create(); 
	    
	    try {
	    	FileWriter writer = new FileWriter("c:/temp/student.json");   
		    writer.write(gson.toJson(student));
		    
		    writer.close();
		    
	    } catch (IOException io) {
	    	io.printStackTrace();
	    }
	     		
	}
	
	
	public Student readJSON() {
		GsonBuilder builder = new GsonBuilder(); 
	    Gson gson = builder.create();
	    Student student = null;
	    
	    try {
	    	BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/temp/student.json"));
	    	student = gson.fromJson(bufferedReader, Student.class);
	    	
	    } catch (IOException io) {
	    	io.printStackTrace();
	    }
	    
	    return student;
	}

	
	public void serialize() {
		Gson gson = new Gson();
		
        String name = "Mahesh Kumar"; 
        long rollNo = 1; 
        boolean verified = false; 
        int[] marks = {100,90,85};
        List<String> names = new ArrayList<>();
        
        names.add("John Doo");
        names.add("Samuel Smith");
        names.add("Michael Jordan");
        
        System.out.println("{"); 
        System.out.println("name: " + gson.toJson(name) +","); 
        System.out.println("rollNo: " + gson.toJson(rollNo) +","); 
        System.out.println("verified: " + gson.toJson(verified) +","); 
        System.out.println("marks:" + gson.toJson(marks));
        System.out.println("people:" + gson.toJson(names));
        System.out.println("}");         
	}

	public void deserialize() {
		Gson gson = new Gson();
		String name;
		long rollNo;
		boolean verified;
		int[] marks;
		
		name = gson.fromJson("'Mahesh Kumar'", String.class); 
	    rollNo = gson.fromJson("1", Long.class); 
	    verified = gson.fromJson("false", Boolean.class); 
	    marks = gson.fromJson("[100,90,85]", int[].class);  
	      
	    System.out.println("name: " + name); 
	    System.out.println("rollNo: " + rollNo); 
	    System.out.println("verified: " +verified); 
	    System.out.println("marks:" + Arrays.toString(marks)); 		
	}

	
	public void tree() 
	{
		String jsonString = "{'name':'Mahesh Kumar', 'age':21,'verified':false,'marks': [100,90,85]}";
		
		 JsonParser parser = new JsonParser();
	     JsonElement rootNode = parser.parse(jsonString);  
	     
	     if ( rootNode.isJsonObject()) {
	    	 JsonObject details = rootNode.getAsJsonObject();
	         JsonElement nameNode = details.get("name");
	         
	         System.out.println("Name: " +nameNode.getAsString()); 
	         
	         JsonElement ageNode = details.get("age");
	         System.out.println("Age: " + ageNode.getAsInt());  
	         
	         JsonElement verifiedNode = details.get("verified"); 
	         System.out.println("Verified: " + (verifiedNode.getAsBoolean() ? "Yes":"No"));  
	         
	         JsonArray marks = details.getAsJsonArray("marks");

	         for (int i = 0; i < marks.size(); i++) { 
	             JsonPrimitive value = marks.get(i).getAsJsonPrimitive(); 
	             System.out.print(value.getAsInt() + " ");  
	          } 	         
	     }
	}
}
