package javaAdvanced.SetAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emailData = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while (!name.equals("stop")){
            String email = scanner.nextLine();
            emailData.put(name, email);
            name = scanner.nextLine();
        }
        emailData.entrySet().removeIf(entry ->
                        entry.getValue().endsWith("uk") ||
                        entry.getValue().endsWith("us") ||
                        entry.getValue().endsWith("com"));
        emailData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
