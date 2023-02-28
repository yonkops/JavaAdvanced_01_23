package javaOOP.WorkingWithAbstraction.Exercise.TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int cycleNumbers = Integer.parseInt(scanner.nextLine());
        changeLight(input, cycleNumbers);
    }

    private static void changeLight(String[] input, int cycleNumbers) {
        for (int i = 0; i < cycleNumbers; i++) {
            for (int j = 0; j < input.length; j++) {
                String temp = TrafficLight.valueOf(input[j]).changeSignal(input[j]);
                input[j] = temp;
            }
            printResult(input);
        }
    }

    private static void printResult(String[] input) {
        for (String str : input){
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
