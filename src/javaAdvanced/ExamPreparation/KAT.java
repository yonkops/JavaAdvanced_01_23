package javaAdvanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int registeredCars = 0;
        int workDays = 0;
        ArrayDeque<Integer> licensePlates = new ArrayDeque<>();
        ArrayDeque<Integer> carStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(licensePlates::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(carStack::push);
        while (!licensePlates.isEmpty() && !carStack.isEmpty()){
            workDays ++;
            // Test input
            //System.out.println(licensePlates.poll() + " " + carStack.pop());
            int plates = licensePlates.poll() / 2;
            int cars = carStack.pop();
            int remain;
            if (plates > cars) {
                remain = (plates - cars) * 2;
                licensePlates.offer(remain);
                registeredCars += cars;
            } else if (plates < cars) {
                remain = cars - plates;
                carStack.addLast(remain);
                registeredCars += plates;
            } else {
                registeredCars += cars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, workDays);
        if (licensePlates.isEmpty() && carStack.isEmpty()){
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!licensePlates.isEmpty()){
            int sum = 0;
            for (int n : licensePlates) {
                sum += n;
            }
            System.out.printf("%d license plates remain!%n", sum);
        } else {
            int sum = 0;
            for (int n : carStack) {
                sum += n;
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        }
    }
}
