package com.rafi.practice.designpattern.factory;

class VehicleFactory {
    public static Vehicle createVehicle(String type, Object... args) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car((String) args[0]);  // args[0] is engineType
                
            case "motorcycle":
                return new Motorcycle((Integer) args[0]);  // args[0] is engineCC
                
            case "bicycle":
                return new Bicycle((String) args[0]);  // args[0] is bikeType
                
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
