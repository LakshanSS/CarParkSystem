package com.lakshan;

/**
 * Created by Lakshan on 9/15/17.
 */

//Class Car
public class Car extends Vehicle {
    private int noOfDoors;//number of doors
    private String colour;//colour of the car

    //Contructor
    public Car(String vehicleId, String vehicleBrand, DateTime entryTime, int noOfDoors, String colour) {
        super("CAR", vehicleId, vehicleBrand, entryTime);
        this.noOfDoors = noOfDoors;
        this.colour = colour;

    }

    //Getter for noOfDoors
    public int getNoOfDoors() {
        return noOfDoors;
    }

    //Getter for colour
    public String getColour() {
        return colour;
    }
}
