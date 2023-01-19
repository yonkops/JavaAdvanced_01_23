package javaAdvanced.SetAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> parkedCar = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            if (direction.equals("IN")){
                parkedCar.add(carNumber);
            } else {
                parkedCar.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (parkedCar.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkedCar
                 ) {
                System.out.println(car);
            }
        }
    }
}
