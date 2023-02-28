package javaAdvanced.Exam_18_02_2023;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class stack {
    private static final int PATCH_VALUE = 30;
    private static final int BANDAGE_VALUE = 40;
    private static final int MEDKIT_VALUE = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(medicaments::push);
        Map<String, Integer> createdItems = new HashMap<>();
        while (!textiles.isEmpty() && !medicaments.isEmpty()){
            int textile = textiles.pop();
            int medicament = medicaments.poll();
            int sumValues = textile + medicament;
            if (sumValues >= MEDKIT_VALUE){
                storeItem(createdItems, "MedKit");
                int newValue = sumValues - MEDKIT_VALUE;
                if (newValue != 0 && !medicaments.isEmpty()){
                    newValue += medicaments.poll();
                    medicaments.offerFirst(newValue);
                } else {
                    //TO DO
                    //System.out.println(medicaments.isEmpty());
                }
                continue;
            } else if (sumValues == BANDAGE_VALUE) {
                storeItem(createdItems, "Bandage");
                continue;
            } else if (sumValues == PATCH_VALUE) {
                storeItem(createdItems, "Patch");
                continue;
            } else {
                //textiles.offerFirst(textile);
                medicaments.offerFirst(medicament + 10);
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }

        List<Map.Entry<String , Integer>> nList = new ArrayList<>(createdItems.entrySet());
        nList.sort(comparingByKey());
        nList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        nList.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        printDeque(medicaments , textiles);

    }
    private static void printDeque(ArrayDeque<Integer> first, ArrayDeque<Integer> second) {
        if (!first.isEmpty()) {
            System.out.printf(
                    "Medicaments left: %s", String.join(", ", Arrays.asList(first.toString())).substring(1, first.toString().length() - 1));
        }
        if (!second.isEmpty()) {
            System.out.printf(
                    "Textiles left: %s", String.join(", ", Arrays.asList(second.toString())).substring(1, second.toString().length() - 1));
        }
    }
    private static void storeItem(Map<String, Integer> mapOfItems, String item) {
        if (mapOfItems.containsKey(item)) {
            mapOfItems
                    .replace(item, mapOfItems.get(item) + 1);
        } else {
            mapOfItems.put(item, 1);
        }
    }
}
