package javaOOP.WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStars = scanner.nextInt();
        scanner.nextLine();
        printTopPart(numberOfStars);
        printMiddlePart(numberOfStars);
        printBottomPart(numberOfStars);
    }

    private static void printBottomPart(int numberOfStars) {
        for (int row = numberOfStars - 1; row >= 1 ; row--) {
            printRow(numberOfStars, row);
        }
    }
    private static void printMiddlePart(int numberOfStars) {
        for (int star = 1; star <= numberOfStars; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    private static void printTopPart(int numberOfStars) {
        for (int row = 1; row <= numberOfStars - 1; row++) {
            printRow(numberOfStars, row);
        }
    }
    private static void printRow(int numberOfStars, int row) {
        for (int space = 1; space <= numberOfStars - row; space++) {
            System.out.print(" ");
        }
        printMiddlePart(row);
    }
}
