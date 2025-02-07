package com.rafi.practice.designpattern.builder;

public class StudentService {
    public void displayStudentInfo(Student student) {
        System.out.println("Student Information:");
        System.out.println("-----------------");
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Roll Number: " + student.getRollNumber());
        if (!student.getEmail().isEmpty()) {
            System.out.println("Email: " + student.getEmail());
        }
        if (!student.getPhone().isEmpty()) {
            System.out.println("Phone: " + student.getPhone());
        }
        if (!student.getAddress().isEmpty()) {
            System.out.println("Address: " + student.getAddress());
        }
        if (student.getAge() > 0) {
            System.out.println("Age: " + student.getAge());
        }
        if (!student.getDepartment().isEmpty()) {
            System.out.println("Department: " + student.getDepartment());
        }
        if (student.getGpa() > 0.0) {
            System.out.println("GPA: " + student.getGpa());
        }
    }
}
