package com.kgdealer.ui;

import java.util.Scanner;

public class UserInterface {

        static Scanner read = new Scanner(System.in);


        public static void startMenu() {
            boolean running = false;
            System.out.println("Press enter to Start the program");
            System.out.println("Press any other key to exit");
            read.nextLine();

            if (read.nextLine().isEmpty()) {
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
                        processGetHyPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetHyColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetMVehiclesRequest();
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

        public void display() {
            // Display implementation
        }

        public void processGetHyPriceRequest() {
            // Process get by price request implementation
        }

        public void processGetByMakeModelRequest() {
            // Process get by make/model request implementation
        }

        public void processGetByYearRequest() {
            // Process get by year request implementation
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

        public void processGetMVehiclesRequest() {
            // Process get vehicles request implementation
        }

        public void processAddVehicleRequest() {
            // Process add vehicle request implementation
        }

        public void processRemoveVehicleRequest() {
            // Process remove vehicle request implementation
        }
}

