package com.kgdealer.Main;

import static com.kgdealer.data.DealershipFileManager.displayVehicles;
import static com.kgdealer.data.DealershipFileManager.getDealership;

public class Program {
    public static void main(String[] args) {

        getDealership();
        displayVehicles();

    }
}
