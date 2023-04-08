package javaOOP.Polymorphism.Exercise.vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Vehicle> data = new LinkedHashMap<>();
        putVehicleToMap(scanner, data);
        putVehicleToMap(scanner, data);
        putVehicleToMap(scanner, data);
        int commandsNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsNumber; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            String vehicle = input[1];
            switch (command){
                case "DriveEmpty" :
                    double distanceEmpty = Double.parseDouble(input[2]);
                    data.get(vehicle).drive(distanceEmpty, vehicle, false);
                    break;
                case "Drive" :
                    double distance = Double.parseDouble(input[2]);
                    data.get(vehicle).drive(distance, vehicle, true);
                    break;
                case "Refuel" :
                    double fuel = Double.parseDouble(input[2]);
                    data.get(input[1]).refuel(fuel);
                    break;
            }
        }
        for (String vehicle : data.keySet()) {
            System.out.printf("%s: %.2f%n",
                    vehicle, data.get(vehicle).getFuelQuantity());
        }


    }
    private static void putVehicleToMap(Scanner scanner, Map<String, Vehicle> data){
        String[]input = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelPerKm = Double.parseDouble(input[2]);
        double tankCapacity = Double.parseDouble(input[3]);
        switch (input[0]) {
            case "Car" :
                Car vehicle = new Car(fuelQuantity, fuelPerKm, tankCapacity);
                data.put(input[0], vehicle);
                break;
            case "Truck" :
                Truck truck = new Truck(fuelQuantity, fuelPerKm, tankCapacity);
                data.put(input[0], truck);
                break;
            case "Bus" :
                Bus bus = new Bus(fuelQuantity, fuelPerKm, tankCapacity);
                data.put(input[0], bus);
                break;
        }
    }

}
