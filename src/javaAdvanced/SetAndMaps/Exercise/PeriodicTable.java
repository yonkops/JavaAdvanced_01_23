package javaAdvanced.SetAndMaps.Exercise;

import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nInput = Integer.parseInt(scanner.nextLine());
        Set<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < nInput; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Collections.addAll(periodicTable, input);
//            periodicTable.addAll(Arrays.stream(input).toList());
        }
        periodicTable.forEach(el -> System.out.print(el + " "));
    }
}
