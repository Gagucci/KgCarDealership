package com.kgdealer.data;

import com.kgdealer.model.Dealership;
import com.kgdealer.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static File file = new File("src/main/resources/inventory.csv");
    public static List<Vehicle> vehicles = new ArrayList<>();

    public static List<Vehicle> getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] column = line.split("\\|");
                if (column.length != 8) {
                    System.out.println("Invalid line format at line: " + line);
                } else {
                    int vin = Integer.parseInt(column[0]);
                    int year = Integer.parseInt(column[1]);
                    String make = column[2];
                    String model = column[3];
                    String vehicleType = column[4];
                    String color = column[5];
                    int odometer = Integer.parseInt(column[6]);
                    double price = Double.parseDouble(column[7]);

                    Vehicle v = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    vehicles.add(v);
                }

            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public void saveDealership(){

    }

    public static void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println("VIN: " + vehicle.getVin() + ", Year: " + vehicle.getYear() + ", Make: " + vehicle.getMake() +
                    ", Model: " + vehicle.getModel() + ", Vehicle Type: " + vehicle.getVehicleType() +
                    ", Color: " + vehicle.getColor() + ", Odometer: " + vehicle.getOdometer() +
                    ", Price: $" + vehicle.getPrice());
        }
    }
}
