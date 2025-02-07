package com.rafi.practice;

import java.util.*;

public class DummyTemp {

	public static void main(String[] args) {
	    List<String> list = new ArrayList<>();
	    list.add("Apple");
	    list.add("Banana");
	    list.add("Orange");
	    list.add("Mango");
	    
	    for (String item : list) {
	        System.out.println("Current item: " + item);
	        // The key is to remove an element that hasn't been processed yet
	        if (item.equals("Apple") || item.equals("Banana")) {
	            list.remove("Orange");  // This will throw exception
	        }
	    }
	}
}
