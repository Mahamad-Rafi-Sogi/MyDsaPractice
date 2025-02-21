package com.rafi.practice;

//Step 1: Mark class as final
public final class ImmutableClass {
 
 // Step 2: Declare fields as private and final
 private final String name;
 private final int age;
 
 // Step 3: Initialize fields in the constructor
 public ImmutableClass(String name, int age) {
     this.name = name;
     this.age = age;
 }

 // Step 4: Provide only getters (No setters!)
 public String getName() {
     return name;
 }

 public int getAge() {
     return age;
 }
 
 public static void main(String[] args) {
     ImmutableClass person = new ImmutableClass("Rafi", 25);
     
     System.out.println(person.getName()); // Output: Rafi
     System.out.println(person.getAge());  // Output: 25
     // person.name = "New Name"; // ❌ Not allowed (Compile-time error)
 }
 
 // Step 5: No methods that modify the object's state
}