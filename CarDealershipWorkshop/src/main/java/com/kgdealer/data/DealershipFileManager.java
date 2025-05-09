package com.kgdealer.data;

import java.io.File;

public class DealershipFileManager {
    File file = new File("src/main/resources/inventory.csv");

    public void checkFile() {
        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
}
