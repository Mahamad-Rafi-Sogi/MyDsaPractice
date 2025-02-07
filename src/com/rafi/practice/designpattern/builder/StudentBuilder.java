package com.rafi.practice.designpattern.builder;

// Builder Class
public class StudentBuilder {
    // Required parameters
    String firstName;
    String lastName;
    int rollNumber;
    
    // Optional parameters - initialized to default values
    String email = "";
    String phone = "";
    String address = "";
    int age = 0;
    String department = "";
    double gpa = 0.0;
    
    public StudentBuilder(String firstName, String lastName, int rollNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
    }
    
    // Methods to set optional parameters
    public StudentBuilder email(String email) {
        this.email = email;
        return this;
    }
    
    public StudentBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    
    public StudentBuilder address(String address) {
        this.address = address;
        return this;
    }
    
    public StudentBuilder age(int age) {
        this.age = age;
        return this;
    }
    
    public StudentBuilder department(String department) {
        this.department = department;
        return this;
    }
    
    public StudentBuilder gpa(double gpa) {
        this.gpa = gpa;
        return this;
    }
    
    // Build method to return the final Student object
    public Student build() {
        validateStudentObject();
        return new Student(this);
    }
    
    private void validateStudentObject() {
        StringBuilder errorMessage = new StringBuilder();
        
        if (firstName == null || firstName.trim().isEmpty()) {
            errorMessage.append("First name is required. ");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            errorMessage.append("Last name is required. ");
        }
        if (rollNumber <= 0) {
            errorMessage.append("Valid roll number is required. ");
        }
        if (age < 0) {
            errorMessage.append("Age cannot be negative. ");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            errorMessage.append("GPA must be between 0.0 and 4.0. ");
        }
        
        if (errorMessage.length() > 0) {
            throw new IllegalStateException(errorMessage.toString());
        }
    }
}