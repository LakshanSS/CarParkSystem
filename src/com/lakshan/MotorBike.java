package com.lakshan;

/**
 * Created by Lakshan on 9/15/17.
 */

//Class MotorBike
public class MotorBike extends Vehicle {
    private int engineCapacity;//Engine Capacity

    //Constructor
    public MotorBike(String vehicleId, String vehicleBrand, DateTime entryTime, int engineCapacity) {
        super("BIKE", vehicleId, vehicleBrand, entryTime);
        this.engineCapacity = engineCapacity;
    }

    //Getter for Engine Capacity
    public int getEngineCapacity() {
        return engineCapacity;
    }
}
