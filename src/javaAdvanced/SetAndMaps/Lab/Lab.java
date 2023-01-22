package javaAdvanced.SetAndMaps.Lab;

import java.util.*;

public class Lab {
    public static void main(String[] args) {
        // Does not guarantee the constant order of elements over time
        HashSet<String> someHashSet = new HashSet<>();
        // The elements are ordered incrementally
        TreeSet<String> someTreeSet = new TreeSet<>();
        // The order of appearance is preserved
        LinkedHashSet<String> soleLinkedHashSet = new LinkedHashSet<>();
        // Print Set
        for (String members : someHashSet
        ) {
            System.out.println(members);
        }
/*        for (Map.Entry<String, Map<String, List<String>>> entry : continents.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Map.Entry<String, List<String>> country : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", country.getKey());
                System.out.print(String.join(", ", country.getValue()));
                System.out.println();
            }
        }*/

        /*
         continents.entrySet().stream()
              .forEach(entry -> {
                  System.out.println(entry.getKey() + ":");
                  entry.getValue().entrySet().stream()
                          .forEach(country -> {
                              String output = String.join(", ", country.getValue());
                              System.out.println(" " + country.getKey() + " -> " + output);
                          });
              });
        */
    }
}
