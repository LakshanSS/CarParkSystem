package com.lakshan;

/**
 * Created by Lakshan on 9/15/17.
 */
public class Van extends Vehicle {
    private double cargoVolumeKg;//Cargo Volume

    //Constructor
    public Van(String vehicleId, String vehicleBrand, DateTime entryTime, double cargoVolumeKg) {
        super("VAN", vehicleId, vehicleBrand, entryTime);
        this.cargoVolumeKg = cargoVolumeKg;
    }

    //Getter Cargo Volume
    public double getCargoVolumeKg() {
        return cargoVolumeKg;
    }

}


