package com.lakshan;

/**
 * Created by Lakshan on 9/15/17.
 */

//Vehicle Class1
public abstract class Vehicle {
    private String vehicleId;//vehicle Id
    private String vehicleBrand;//vehicle Brand
    private String vehicleType;//type of the vehicle
    private DateTime entryTime;//time of entry
    private DateTime exitTime;//time of exit
    private boolean currentlyParked;//to know whether it is parked now or not

    //Constructor
    public Vehicle(String vehicleType, String vehicleId, String vehicleBrand, DateTime entryTime) {
        this.vehicleId = vehicleId;
        this.vehicleBrand = vehicleBrand;
        this.entryTime = entryTime;
        this.currentlyParked = true;
        this.vehicleType = vehicleType;
    }

    //Getter for vehicleId
    public String getVehicleId() {
        return vehicleId;
    }

    //Getter gor vehicle brand
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    //Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    //getter for entry time
    public DateTime getEntryTime() {
        return entryTime;
    }

    //getter for exit time
    public DateTime getExitTime() {
        return exitTime;
    }

    //getter for currently parked
    public boolean isCurrentlyParked() {
        return currentlyParked;
    }

    //setter for currently parked
    public void setCurrentlyParked(boolean currentlyParked) {
        this.currentlyParked = currentlyParked;
    }

    //setter for exit time
    public void setExitTime(DateTime exitTime) {
        this.exitTime = exitTime;
    }
}
