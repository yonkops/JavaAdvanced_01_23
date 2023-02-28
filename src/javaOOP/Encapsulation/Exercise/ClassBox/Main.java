package javaOOP.Encapsulation.Exercise.ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        Box box = new Box(length, width, height);
        System.out.printf("Surface Area - %.2f\n" +
                "Lateral Surface Area - %.2f\n" +
                "Volume – %.2f",
                box.calculateSurfaceArea(), box.calculateLateralSurfaceArea(),
                box.calculateVolume());
    }
}
