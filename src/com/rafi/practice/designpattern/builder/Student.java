package com.rafi.practice.designpattern.builder;

public class Student {
    // Required parameters
    private final String firstName;
    private final String lastName;
    private final int rollNumber;
    
    // Optional parameters
    private final String email;
    private final String phone;
    private final String address;
    private final int age;
    private final String department;
    private final double gpa;
    
    Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.rollNumber = builder.rollNumber;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
        this.department = builder.department;
        this.gpa = builder.gpa;
    }
    
    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getRollNumber() { return rollNumber; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getGpa() { return gpa; }
    
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rollNumber=" + rollNumber +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
