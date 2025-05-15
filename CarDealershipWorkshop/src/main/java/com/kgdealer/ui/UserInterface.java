package com.kgdealer.ui;

import com.kgdealer.data.DealershipFileManager;
import com.kgdealer.model.Dealership;
import com.kgdealer.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    static Scanner read = new Scanner(System.in);

    public void init() {
        this.dealership = new Dealership("KG Dealership", "123 Main St", "555-1234");
    }


    public void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("Displaying vehicles:");
        System.out.printf("%-10s %-6s %-10s %-10s %-15s %-10s %-10s %-10s%n",
                "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-10s %-6d %-10s %-10s %-15s %-10s %-10d %-10.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }


    public void display() {
        init();
        boolean running = false;
        System.out.println("Press enter to Start the program");
        System.out.println("Press any other key to exit");
        String start = read.nextLine();

        if (start.isEmpty()) {
            System.out.println("Starting the program...");
            running = true;
        } else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }

        // Start menu implementation
        while (running) {
            System.out.println("Welcome to the Dealership Management System");
            System.out.println("1 | Find vehicles within a price range");
            System.out.println("2 | Find vehicles by make / model");
            System.out.println("3 | Find vehicles by year range");
            System.out.println("4 | Find vehicles by color");
            System.out.println("5 | Find vehicles by mileage range");
            System.out.println("6 | Find vehicles by vehicle type");
            System.out.println("7 | View all vehicles");
            System.out.println("8 | Add a vehicle");
            System.out.println("9 | Remove a vehicle");
            System.out.println("0 | Exit");
            System.out.println("Please select an option: ");
            System.out.print("> ");
            int choice = read.nextInt();
            read.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    //processGetByYearRequest();
                    break;
                case 4:
                    //processGetHyColorRequest();
                    break;
                case 5:
                    //processGetByMileageRequest();
                    break;
                case 6:
                    //processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        while (!read.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter minimum price: ");
            read.next();
        }
        double minPrice = read.nextDouble();

        System.out.print("Enter maximum price: ");
        while (!read.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter maximum price: ");
            read.next();
        }
        double maxPrice = read.nextDouble();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }


    public void processGetByMakeModelRequest() {
        System.out.println("Enter make (leave blank to skip): ");
        String make = read.nextLine();
        while (!make.isEmpty() && !make.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter only letters or leave blank.");
            System.out.println("Enter make (leave blank to skip): ");
            make = read.nextLine();
        }

        System.out.println("Enter model (leave blank to skip): ");
        String model = read.nextLine();
        while (!model.isEmpty() && !model.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter only letters or leave blank.");
            System.out.println("Enter model (leave blank to skip): ");
            model = read.nextLine();
        }
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }


    public void processGetByYearRequest() {

        System.out.print("Enter minimum year: ");
        while (!read.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter minimum year: ");
            read.next();
        }
        int minYear = read.nextInt();
        System.out.print("Enter maximum year: ");
        while (!read.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.out.print("Enter maximum year: ");
            read.next();
        }
        int maxYear = read.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }


    public void processGetHyColorRequest() {
        // Process get by color request implementation
    }


    public void processGetByMileageRequest() {
        // Process get by mileage request implementation
    }


    public void processGetByVehicleTypeRequest() {
        // Process get by vehicle type request implementation
    }


    public void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            displayVehicles(vehicles);
        }
    }


    public void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        while (!read.hasNextInt()) {
            System.out.println("Invalid input. VIN must be a number.");
            System.out.print("Enter VIN: ");
            read.next();
        }
        int vin = read.nextInt();

        System.out.print("Enter year: ");
        while (!read.hasNextInt()) {
            System.out.println("Invalid input. Year must be a number.");
            System.out.print("Enter year: ");
            read.next();
        }
        int year = read.nextInt();
        read.nextLine();

        System.out.print("Enter make: ");
        String make = read.nextLine();

        System.out.print("Enter model: ");
        String model = read.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = read.nextLine();

        System.out.print("Enter color: ");
        String color = read.nextLine();

        System.out.print("Enter odometer: ");
        while (!read.hasNextInt()) {
            System.out.println("Invalid input. Odometer must be a number.");
            System.out.print("Enter odometer: ");
            read.next();
        }
        int odometer = read.nextInt();

        System.out.print("Enter price: ");
        while (!read.hasNextDouble()) {
            System.out.println("Invalid input. Price must be a number.");
            System.out.print("Enter price: ");
            read.next();
        }
        double price = read.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully.");
    }



    public void processRemoveVehicleRequest() {

            processGetAllVehiclesRequest();
            System.out.print("Enter the VIN of the vehicle to remove: ");
            while (!read.hasNextInt()) {
                System.out.println("Invalid input. VIN must be a number.");
                System.out.print("Enter the VIN of the vehicle to remove: ");
                read.next();
            }
            int vin = read.nextInt();
            read.nextLine();

            dealership.removeVehicle(vin);
            System.out.println("Vehicle with VIN " + vin + " has been removed successfully.");
            System.out.println("Updated vehicle list:");
            ArrayList<Vehicle> vehicles = dealership.getVehicles();
            if (vehicles.isEmpty()) {
                System.out.println("No vehicles found.");
            } else {
                displayVehicles(vehicles);
            }

            DealershipFileManager.saveDealership(dealership.getVehicles());
    }

}

