package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Asset> assets = new ArrayList<>();

        // Add two houses
        assets.add(new House("My House",
                "2020-05-15",
                BigDecimal.valueOf(250000),
                "123 Main St", 1, 2000, 5000
        ));

        assets.add(new House(
                "Vacation Home",
                "2022-08-10",
                BigDecimal.valueOf(180000),
                "456 Beach Rd", 2, 1500, 3000
        ));

        // Add two vehicles
        assets.add(new Vehicle("My Car",
                "2023-03-20",
                BigDecimal.valueOf(30000),
                "Toyota Camry", 2022, 45000
        ));

        assets.add(new Vehicle("Tom's Truck",
                "2021-06-12",
                BigDecimal.valueOf(45000),
                "Ford F-150", 2020, 120000
        ));

        // Display all assets
        for (Asset asset : assets) {
            System.out.println("\n=== ASSET ===");
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.println("Original Cost: $" + asset.getOriginalCost());
            System.out.println("Current Value: $" + asset.getValue());

            // check for object class, cast and call a member method
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());

            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Vehicle: " + vehicle.getYear()
                        + " " + vehicle.getMakeModel());
            }
        }
    }
}