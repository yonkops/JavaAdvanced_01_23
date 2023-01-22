package javaAdvanced.SetAndMaps.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, String> phoneBook = new HashMap<>();
        String name = "";
        String number = "";
        while (!text.equals("search")){
            name = text.split("-")[0];
            number = text.split("-")[1];
            if (!phoneBook.containsKey(number)){
                phoneBook.put(name,number);
            } else {
                phoneBook.replace(name, number);
            }
            text = scanner.nextLine();
        }
        text = scanner.nextLine();
        while(!text.equals("stop")) {
            if (phoneBook.containsKey(text)){
                System.out.println(text + " -> " + phoneBook.get(text));
            } else {
                System.out.printf("Contact %s does not exist.%n", text);
            }
            text = scanner.nextLine();
        }
    }
}
