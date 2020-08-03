package com.lakshan;

import java.util.ArrayList;

import static com.lakshan.Main.sc;

/**
 * Created by Lakshan on 9/15/17.
 */
public class WestminsterCarParkManager implements CarParkManager {

    //Arraylist to store all the vehicles
    private static ArrayList<Vehicle> vehicleArr = new ArrayList<Vehicle>();
    private static int noOfFreeSlots = 20;//Free Slots
    private static int noOfCars;//No of cars
    private static int noOfVans;//No of vans
    private static int noOfBikes;//No of bikes


    //method to Add a vehicle
    @Override
    public void addVehicle() {
        if (noOfFreeSlots > 0) {
            //Get info about the vehicle
            System.out.print("Enter VehicleID :");
            String vehicleId = sc.next();
            System.out.print("Enter Vehicle Brand :");
            String vehicleBrand = sc.next();
            System.out.print("Enter entry date and time\nYear :");
            int year = sc.nextInt();
            System.out.print("Month :");
            int month = sc.nextInt();
            System.out.print("Day :");
            int day = sc.nextInt();
            System.out.print("Hour :");
            int hour = sc.nextInt();
            System.out.print("Minutes :");
            int minutes = sc.nextInt();

            //Create the date object
            DateTime d = new DateTime(year, month, day, hour, minutes);
            System.out.println("Enter vehicle type\nC: Car\nV: Van\nB: MotorBike");
            String type = sc.next();
            switch (type.toUpperCase()) {
                case "C": {
                    System.out.println("Enter number of doors");
                    int noOfDoors = sc.nextInt();
                    System.out.println("Enter colour of the car");
                    String colur = sc.next();
                    Vehicle v = new Car(vehicleId, vehicleBrand, d, noOfDoors, colur);
                    vehicleArr.add(v);
                    noOfCars++;
                    noOfFreeSlots--;
                    break;
                }
                case "V": {
                    if (noOfFreeSlots > 1) {
                        System.out.println("Enter cargo volume");
                        double cargoVolume = sc.nextDouble();
                        Vehicle v = new Van(vehicleId, vehicleBrand, d, cargoVolume);
                        vehicleArr.add(v);
                        noOfVans++;
                        noOfFreeSlots -= 2;
                    } else {
                        System.out.println("Only one slot available. Can't park a van");
                    }

                    break;
                }
                case "B": {
                    System.out.println("Enter Engine Capacity");
                    int engineCapacity = sc.nextInt();
                    Vehicle v = new MotorBike(vehicleId, vehicleBrand, d, engineCapacity);
                    vehicleArr.add(v);
                    noOfBikes++;
                    noOfFreeSlots--;
                    break;
                }
                default: {
                    System.out.println("Invalid option");
                    addVehicle();
                }
            }
            System.out.println("Vehicle has been added successfully\nFree Slots Remaining: " + noOfFreeSlots);
        } else {
            System.out.println("There are no free lots available");
        }

        Main.MainMenu();


    }

    //Method to delete a vehicle
    @Override
    public void deleteVehicle() {
        boolean vehicleFound = false;
        System.out.println("Enter VehicleID");
        String vehicleId = sc.next();

        for (int i = 0; i < vehicleArr.size(); i++) {
            if (vehicleId.equals(vehicleArr.get(i).getVehicleId())) {
                vehicleFound = true;
                System.out.print("Enter exit date and time\nYear :");
                int year = sc.nextInt();
                System.out.print("Month :");
                int month = sc.nextInt();
                System.out.print("Day :");
                int day = sc.nextInt();
                System.out.print("Hour :");
                int hour = sc.nextInt();
                System.out.print("Minutes :");
                int minutes = sc.nextInt();
                DateTime d = new DateTime(year, month, day, hour, minutes);
                vehicleArr.get(i).setExitTime(d);
                vehicleArr.get(i).setCurrentlyParked(false);
                int entryMinutes = (vehicleArr.get(i).getEntryTime().getHour() * 60) + vehicleArr.get(i).getEntryTime().getMinutes();
                int exitMinutes = (hour * 60) + minutes;
                int durationHours = (exitMinutes - entryMinutes) / 60;
                if (entryMinutes > exitMinutes) {
                    durationHours = (((24 - vehicleArr.get(i).getEntryTime().getHour()) * 60) + vehicleArr.get(i).getEntryTime().getMinutes() +
                            (hour * 60) + minutes) / 60;
                }
                System.out.println("Vehicle Type: " + vehicleArr.get(i).getVehicleType());
                System.out.println("Parking Charge: " + calculateParkingCharge(durationHours));
                if (vehicleArr.get(i).getVehicleType().equals("van")) {
                    noOfFreeSlots += 2;
                } else {
                    noOfFreeSlots++;
                }
                System.out.println("No of Free Slots: " + noOfFreeSlots);

            }
        }


        if (!vehicleFound) {
            System.out.println("vehicleId not found");
        }

        Main.MainMenu();
    }

    //Method to get currenlty parked vehicles
    @Override
    public void currentVehicles() {
        System.out.println("Currently Parked Vehicles\n");
        for (int x = vehicleArr.size() - 1; x >= 0; x--) {
            if (vehicleArr.get(x).isCurrentlyParked() == true) {
                System.out.println(vehicleArr.get(x).getVehicleId() + " " + vehicleArr.get(x).getVehicleType() + " " +
                        vehicleArr.get(x).getEntryTime().getDate() + " " + vehicleArr.get(x).getEntryTime().getTime());
            }
        }

        if (vehicleArr.size() == 0) {
            System.out.println("There are no vehicles parked currently");
        }
        Main.MainMenu();

    }

    //Method to print statistics
    @Override
    public void printStatics() {
        //Method to print statistics
        System.out.println("Total parked vehicles : " + vehicleArr.size());
        System.out.println("Percentage of Cars : " + Math.round((double) noOfCars / vehicleArr.size() * 10000.0) / 100.0);
        System.out.println("Percentage of Vans : " + Math.round((double) noOfVans / vehicleArr.size() * 10000.0) / 100.0);
        System.out.println("Percentage of Bikes : " + Math.round((double) noOfBikes / vehicleArr.size() * 10000.0) / 100.0);
        if (vehicleArr.size() > 0) {
            System.out.println("Last parked vehicle: " + vehicleArr.get((vehicleArr.size() - 1)).getVehicleId()
                    + " " + vehicleArr.get((vehicleArr.size() - 1)).getVehicleType() + " " +
                    vehicleArr.get((vehicleArr.size() - 1)).getEntryTime().getDate()
                    + " " + vehicleArr.get((vehicleArr.size() - 1)).getEntryTime().getTime());
            for (int i = 0; i < vehicleArr.size(); i++) {
                if (vehicleArr.get(i).isCurrentlyParked() == true) {
                    System.out.println("Longest parked vehicle: " + vehicleArr.get(i).getVehicleId() +
                            " " + vehicleArr.get(i).getVehicleType() + " " + vehicleArr.get(i).getEntryTime().getDate() +
                            " " + vehicleArr.get(i).getEntryTime().getTime());
                    break;
                }
            }
        }

        Main.MainMenu();
    }

    //Method to get the vehicle list
    @Override
    public void vehicleList() {
        System.out.print("Enter Year :");
        int year = sc.nextInt();
        System.out.print("Enter Month :");
        int month = sc.nextInt();
        System.out.print("Enter Day :");
        int day = sc.nextInt();

        String date = year + "." + month + "." + day;
        boolean nothingFound = true;

        System.out.println("\n");
        for (int x = 0; x < vehicleArr.size(); x++) {
            if (date.equals(vehicleArr.get(x).getEntryTime().getDate())) {
                System.out.println(vehicleArr.get(x).getVehicleId() + " " + vehicleArr.get(x).getVehicleType());
                nothingFound = false;
            }
        }

        if (nothingFound == true) {
            System.out.println("There were no vehicles parked on the day");
        }

        Main.MainMenu();

    }

    //Calculation of the parking charge
    public double calculateParkingCharge(int hours) {
        int bill = 0;

        if (hours <= 3) {
            bill = hours * 3;
        } else if (hours > 3) {
            bill = 9 + (hours - 3);
        }
        return bill;
    }
}
