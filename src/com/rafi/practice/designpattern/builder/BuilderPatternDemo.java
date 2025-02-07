package com.rafi.practice.designpattern.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        try {
            // Create a student with minimum required fields
            Student student1 = new StudentBuilder("John", "Doe", 101)
                    .build();
            
            // Create a student with all fields
            Student student2 = new StudentBuilder("Jane", "Smith", 102)
                    .email("jane.smith@example.com")
                    .phone("123-456-7890")
                    .address("123 Main St")
                    .age(20)
                    .department("Computer Science")
                    .gpa(3.8)
                    .build();
            
            // Create a student with some optional fields
            Student student3 = new StudentBuilder("Bob", "Johnson", 103)
                    .email("bob.j@example.com")
                    .department("Physics")
                    .gpa(3.5)
                    .build();
            
            // Display student information using service
            StudentService service = new StudentService();
            System.out.println("\nStudent 1:");
            service.displayStudentInfo(student1);
            
            System.out.println("\nStudent 2:");
            service.displayStudentInfo(student2);
            
            System.out.println("\nStudent 3:");
            service.displayStudentInfo(student3);
            
            // Try to create an invalid student (will throw exception)
            Student invalidStudent = new StudentBuilder("", "Invalid", -1)
                    .gpa(5.0)
                    .age(-5)
                    .build();
            
        } catch (IllegalStateException e) {
            System.out.println("\nError creating student: " + e.getMessage());
        }
    }
}
