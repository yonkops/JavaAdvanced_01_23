package javaAdvanced.FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier <връща> -> get
        //Predicate<приема> -> връща true/false -> test
        //BiFunction<приема1, приема2, връща> -> apply
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        /*Consumer<String> printName = name -> System.out.println(name);
        for (String name : names){
            printName.accept(name);
        }*/

        Consumer<String[]> printArray = array -> {
            for (String name : array){
                System.out.println(name);
            }
        };
        printArray.accept(names);
    }
}
