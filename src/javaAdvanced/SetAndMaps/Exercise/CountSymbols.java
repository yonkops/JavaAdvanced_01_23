package javaAdvanced.SetAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> symbolsCounter = new TreeMap<>();
        for (char ch : text.toCharArray()) {
            if (!symbolsCounter.containsKey(ch)){
                symbolsCounter.put(ch, 1);
            } else {
                int temp = symbolsCounter.get(ch);
                symbolsCounter.replace(ch, temp + 1);
            }
        }
        symbolsCounter.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
    }
}
