package javaAdvanced.ExamPreparation;


import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = (Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        putInArrayDeque(input, ingredients, "queue");

        input = (Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)).toArray();
        ArrayDeque<Integer> freshIngredients = new ArrayDeque<>();
        putInArrayDeque(input, freshIngredients, "stack");

        Map<String, Integer> cocktails = new TreeMap<>();
        makeCocktails(ingredients, freshIngredients, cocktails);

        if (cocktails.size() == 4 && ingredients.isEmpty() && freshIngredients.isEmpty()){
            System.out.println("It's party time! The cocktails are ready!");
        } else if (!ingredients.isEmpty()){
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            int sum = 0;
            for (int number : ingredients){
                sum += number;
            }
            System.out.println("Ingredients left: " + sum);
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        printCocktails(cocktails);
    }

    private static void printCocktails(Map<String, Integer> cocktails) {
        for (String value : cocktails.keySet()){
            System.out.printf(" # %s --> %d%n", value, cocktails.get(value));
        }
    }

    private static void makeCocktails(ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshIngredients, Map<String, Integer> cocktails) {
        while (!ingredients.isEmpty() && !freshIngredients.isEmpty()){
            int firstIngredient = ingredients.poll();
            if (firstIngredient == 0){
                continue;
            }
            int secondIngredient = freshIngredients.pop();
            int mix = firstIngredient * secondIngredient;
            if (mix == 400){
                if (cocktails.containsKey("High Fashion")){
                    int value = cocktails.get("High Fashion");
                    cocktails.replace("High Fashion", (value + 1));
                } else{
                    cocktails.putIfAbsent("High Fashion", 1);
                }
            } else if (mix == 300) {
                if (cocktails.containsKey("Apple Hinny")){
                    int value = cocktails.get("Apple Hinny");
                    cocktails.replace("Apple Hinny", (value + 1));
                } else {
                    cocktails.putIfAbsent("Apple Hinny", 1);
                }
            } else if (mix == 250) {
                if (cocktails.containsKey("The Harvest")){
                    int value = cocktails.get("The Harvest");
                    cocktails.replace("The Harvest", (value + 1));
                } else {
                    cocktails.putIfAbsent("The Harvest", 1);
                }
            } else if (mix == 150) {
                if (cocktails.containsKey("Pear Sour")){
                    int value = cocktails.get("Pear Sour");
                    cocktails.replace("Pear Sour", (value + 1));
                } else {
                    cocktails.putIfAbsent("Pear Sour", 1);
                }
            } else {
                firstIngredient += 5;
                ingredients.offer(firstIngredient);
            }
        }
    }

    private static void putInArrayDeque(int[] input, ArrayDeque<Integer> ingredients, String command) {
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
