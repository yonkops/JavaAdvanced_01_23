package javaAdvanced.SetAndMaps.Lab;

import java.sql.Array;
import java.util.*;

public class CitiesContinentCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        int numOfInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfInputs; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            ArrayList<String> list = new ArrayList<>();
            // if continent exist
            continents.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>>countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            countries.get(country).add(city);
        }

        continents.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().entrySet().stream()
                            .forEach(country -> {
                                String output = String.join(", ", country.getValue());
                                System.out.println(" " + country.getKey() + " -> " + output);
                            });
                });
    }
}
