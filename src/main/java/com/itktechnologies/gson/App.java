package com.itktechnologies.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("User Simple implementation...");
    	serializeUserSimple();
    	deserializeUserSimple();
    	System.out.println("\n\n");
    	
    	System.out.println("UserNested Simple implementation...");
    	serializeUserNested();
    	deserializeUserNested();
    	System.out.println("\n\n");
    	
    	System.out.println("Bakery implementation...");
    	serializeBakery();
    	deserializeFounder();
    	
    }
    
    private static void serializeUserSimple() {
    	
    	UserSimple user = new UserSimple("Alexandre Geraldo", "ageraldo@itktechnologies.com", 39, true);
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(user);
    	
    	System.out.println(json);
    	
    	
    	
    }


    private static void deserializeUserSimple() {
    	
    	String userJson = "{'name':'Alex Geraldo','email':'alexandre_geraldo@hotmail.com','age':39,'isDeveloper':false}";
    	
    	Gson gson = new Gson();
    	UserSimple user = gson.fromJson(userJson, UserSimple.class);
    	
    	System.out.println(user);
    	
    
    	
    }


    private static void serializeUserNested() {
    	UserAddress address = new UserAddress("Capstone CT", "1020", "Suwanee", "USA");
    	UserNested user = new UserNested("Alexandre Geraldo", "ageraldo@itktechnlogies.com", 39, true, address );
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(user);
    	
    	System.out.println(json);
    	
    	
    }
    
    private static void  deserializeUserNested() {
    	String json = "{'name': 'Future Studio Steak House','owner': {'name': 'Alexandre', 'address': {'city': 'Suwanee','country': 'USA','houseNumber': '1020','street': 'Capstone CT'}},'cook': {'age': 18,'name': 'Marcus','salary': 1500},'waiter': {'age': 18,'name': 'Norman','salary': 1000}}";
    	
    	Restaurant restaurant = new Gson().fromJson(json, Restaurant.class);
    	
    	System.out.print(restaurant);
    	
    			
    	
    }

    private static void serializeBakery() {
    	List<MenuItem> menuItems = new ArrayList<>();
    	
    	menuItems.add(new MenuItem("Steak", 20));
    	menuItems.add(new MenuItem("Egg", 10));
    	menuItems.add(new MenuItem("Coffee", 1.5));
    	menuItems.add(new MenuItem("Water", 1.0));
    	
    	Bakery bakery = new Bakery("Future Studio Bakery", menuItems);
    	
    	String json = new Gson().toJson(bakery);
    	
    	System.out.println(json);
    }
    
    private static void deserializeFounder() {
    	String json = "[{'name': 'Christian','flowerCount': 1},{'name': 'Marcus','flowerCount': 3},{'name': 'Norman','flowerCount': 2}]";
    	
    	
    	System.out.println ("Using Array....");
    	Founder[] founders = new Gson().fromJson(json, Founder[].class);
    	
    	for ( int i = 0; i < founders.length; i++) {
    		System.out.println(founders[i]);
    	}
    	
    	System.out.println ("Using a List....");
    	Type foundListType = new TypeToken<ArrayList<Founder>>(){}.getType();
    	List<Founder> listFounders = new Gson().fromJson(json, foundListType);
    	Iterator<Founder> iterator = listFounders.iterator();
    	
    	while ( iterator.hasNext()) {
    		System.out.println (iterator.next());
    	}
    }
    	

}
