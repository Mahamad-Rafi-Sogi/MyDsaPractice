package com.rafi.practice.java17;

//Defining a Record
record Employee(String name, int age, String department) {}

public class Record {
 public static void main(String[] args) {
     Employee emp = new Employee("Rafi", 25, "Engineering");

     // Getters are auto-generated
     System.out.println(emp.name());  // Output: Rafi
     System.out.println(emp.age());   // Output: 25
     System.out.println(emp.department()); // Output: Engineering

     // Auto-generated toString()
     System.out.println(emp); // Output: Employee[name=Rafi, age=25, department=Engineering]
 }
}