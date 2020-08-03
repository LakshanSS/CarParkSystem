package com.lakshan;

import java.util.Scanner;

/**
 * Created by Lakshan on 9/22/17.
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);//Scanner
    public static WestminsterCarParkManager w = new WestminsterCarParkManager();

    //Main method
    public static void main(String[] args) {
        System.out.println("Westminster Carpark Manager\n");
        MainMenu();

    }

    //Method for Menu Option
    public static void MainMenu() {
        System.out.println("\n-----Main Menu----\nA: Add a VEHICLE\nD: Delete a Vehicle\nC: Currently Parked Vehicles\n" +
                "L: List of Vehicles\nS: View Statics\nQ: Quit Program");

        switch (sc.next().toUpperCase()) {
            case "A": {
                w.addVehicle();
                break;
            }
            case "D": {
                w.deleteVehicle();
                break;
            }
            case "C": {
                w.currentVehicles();
                break;
            }
            case "L": {
                w.vehicleList();
                break;
            }
            case "S": {
                w.printStatics();
                break;
            }
            case "Q": {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("\n\n***Please select a valid option\n");
                MainMenu();
                break;
            }
        }
    }
}
