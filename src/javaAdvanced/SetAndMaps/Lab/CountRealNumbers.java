package javaAdvanced.SetAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> countRealNumbers = new LinkedHashMap<>();
        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());
        for (Double number : numbers
             ) {
            if (countRealNumbers.containsKey(number)){
                countRealNumbers.replace(number, countRealNumbers.get(number) + 1);
            } else {
                countRealNumbers.put(number, 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : countRealNumbers.entrySet()) {
            String output = String.format("%.1f -> %d", entry.getKey(), entry.getValue());
            System.out.println(output);
        }
    }
}
