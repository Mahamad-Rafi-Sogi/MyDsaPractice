package com.rafi.practice.designpattern.singleton;

public class MainClass {
	public static void main(String[] args) {
		DatabaseConnection db1 = DatabaseConnection.getInstance();
		DatabaseConnection db2 = DatabaseConnection.getInstance(); 
		
		db1.connect();
		db2.connect();
	}
}
