package javaAdvanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop {
    private static final int BISCUIT_VALUE = 25;
    private static final int CAKE_VALUE = 50;
    private static final int PASTRY_VALUE = 75;
    private static final int PIE_VALUE = 100;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] input = (Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)).toArray();
        Deque<Integer> liquids = new ArrayDeque<>();
        Deque<Integer> ingredients = new ArrayDeque<>();
        putInArrayDeque(input, liquids, "queue");
        input = (Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)).toArray();
        putInArrayDeque(input, ingredients, "stack");
        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;
        while (!liquids.isEmpty() && !ingredients.isEmpty()){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int dishCheck = liquid + ingredient;
            switch (dishCheck){
                case BISCUIT_VALUE : biscuitCount++; break;
                case CAKE_VALUE: cakeCount++; break;
                case PASTRY_VALUE: pastryCount++; break;
                case PIE_VALUE: pieCount++; break;
                default: ingredients.push(ingredient + 3); break;
            }
        }
        if (biscuitCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquids.isEmpty()){
            System.out.println("none");
        } else {
            //System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
            String leftThreads = liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(leftThreads);
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()){
            System.out.println("none");
        } else {
            //System.out.println(ingredients.toString().replaceAll("[\\[\\]]", ""));
            String leftThreads = ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(leftThreads);
        }
        System.out.printf(
                "Biscuit: %d\n" +
                        "Cake: %d\n" +
                        "Pie: %d\n" +
                        "Pastry: %d\n",
                biscuitCount, cakeCount, pieCount, pastryCount);
    }
    private static void putInArrayDeque(int[] input, Deque<Integer> ingredients, String command) {
        if (command.equals("stack")){
            for(int value : input){
                ingredients.push(value);
            }
        } else if (command.equals("queue")) {
            for (int value : input){
                ingredients.offer(value);
            }
        }

    }
}
