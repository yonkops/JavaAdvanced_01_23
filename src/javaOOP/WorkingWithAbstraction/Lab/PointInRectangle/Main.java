package javaOOP.WorkingWithAbstraction.Lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = getIntArray(scanner);
        Point bottomLeft = new Point(coordinates[0], coordinates[1] );
        Point topRight = new Point(coordinates[2], coordinates[3] );
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            coordinates = getIntArray(scanner);
            checkGivenCoordinatesIsInRectangle(rectangle, coordinates[0], coordinates[1]);
        }
    }

    private static int[] getIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
    private static void checkGivenCoordinatesIsInRectangle(Rectangle rectangle, int x, int y) {
        Point searchedPoints = new Point(x, y);
        System.out.println(rectangle.contains(searchedPoints));
    }
}
