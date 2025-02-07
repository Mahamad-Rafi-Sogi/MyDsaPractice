package com.rafi.practice.designpattern.singleton;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;
    
    // this is for Using static initialization(eager initialization)
    //private static final Singleton instance = new Singleton();
    
    //private constructor to avoid creation of object from public controller
    private DatabaseConnection() {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
    }
    
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
        	synchronized (DatabaseConnection.class) { // Using double checked locking(DCL)
            instance = new DatabaseConnection();
        	}
        }
        return instance;
    }
    
    public void connect() {
        System.out.println("Connected to: " + connectionString);
    }
    
    // Override clone to prevent cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        // Either throw an exception
        throw new CloneNotSupportedException("Cloning of singleton not allowed");
        
        // OR return the same instance
        // return instance;
    }
    
    // Prevent serialization issues
    public Object readResolve() {
        return getInstance();
    }
    
}