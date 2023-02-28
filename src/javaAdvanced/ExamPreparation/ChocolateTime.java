package javaAdvanced.ExamPreparation;

import java.util.*;

public class ChocolateTime {
    private static final int MILK_CHOCO_VALUE = 30;
    private static final int DAR_CHOCO_VALUE = 50;
    private static final int BAKING_CHOCO_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowderQuantity = new ArrayDeque<>();
        Map<String, Integer> chocolateTypes = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(milkQuantity::offer);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).forEach(cacaoPowderQuantity::push);
        while (!milkQuantity.isEmpty() && !cacaoPowderQuantity.isEmpty()){
            double milk = milkQuantity.poll();
            double cacao = cacaoPowderQuantity.pop();
            double mix = milk + cacao;
            int cacaoValue = (int) Math.ceil((cacao / mix) * 100);
            if (cacaoValue == BAKING_CHOCO_VALUE){
                makeChocolate(chocolateTypes, "Baking Chocolate");
            } else if (cacaoValue ==  DAR_CHOCO_VALUE) {
                makeChocolate(chocolateTypes, "Dark Chocolate");
            } else if (cacaoValue ==  MILK_CHOCO_VALUE) {
                makeChocolate(chocolateTypes, "Milk Chocolate");
            } else{
                milk += 10;
                milkQuantity.offer(milk);
            }
        }
        printResult(chocolateTypes);
    }

    private static void printResult(Map<String, Integer> chocolateTypes) {
        if (chocolateTypes.size() >= 3){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Integer> entry : chocolateTypes.entrySet()) {
            String output = String.format("# %s --> %d", entry.getKey(), entry.getValue());
            System.out.println(output);
        }
    }

    private static void makeChocolate(Map<String, Integer> chocolateTypes, String chocolate) {
        if (chocolateTypes.containsKey(chocolate)) {
            chocolateTypes
                    .replace(chocolate, chocolateTypes.get(chocolate) + 1);
        } else {
            chocolateTypes.put(chocolate, 1);
        }
    }
}
