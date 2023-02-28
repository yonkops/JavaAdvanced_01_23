package javaAdvanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> mgCaffeine = new ArrayDeque<>();
        Deque<Integer> energyDrinks = new ArrayDeque<>();
        int caffeineTaken = 0;
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(mgCaffeine::push);
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).forEach(energyDrinks::offer);
        while (!mgCaffeine.isEmpty() && !energyDrinks.isEmpty()){
            int caffeine = mgCaffeine.pop();
            int drink = energyDrinks.poll();
            int portionCaffeine = caffeine * drink;
            if (300 >= caffeineTaken + portionCaffeine){
                caffeineTaken += portionCaffeine;
            } else {
                if (caffeineTaken >= 30){
                    caffeineTaken -= 30;
                }
                energyDrinks.offer(drink);
            }
        }
        if (!energyDrinks.isEmpty()){
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(energyDrinks.toString().
                    substring(1, energyDrinks.toString().length() - 1))));
            //printResult(energyDrinks);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", (caffeineTaken));
    }


}
