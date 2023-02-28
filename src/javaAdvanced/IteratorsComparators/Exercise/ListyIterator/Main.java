package javaAdvanced.IteratorsComparators.Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator<String> listyIterator = new ListyIterator<>();
        while (!input.equals("END")){
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "Create":
                    if (command.length > 1){
                        listyIterator = new ListyIterator<>(
                                Arrays.copyOfRange(command, 1, command.length)
                        );
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalArgumentException iae){
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
