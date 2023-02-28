package javaAdvanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        // add
        Function<List<Integer>, List<Integer>> addCommand =
                list -> list.stream().map(number -> number += 1)
                        .collect(Collectors.toList());
        // multiply
        Function<List<Integer>, List<Integer>> multiplyCommand =
                list -> list.stream().map(number -> number *= 2)
                        .collect(Collectors.toList());
        // subtract
        Function<List<Integer>, List<Integer>> substractCommand =
                list -> list.stream().map(number -> number -= 1)
                        .collect(Collectors.toList());
        //print
        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        while (!command.equals("end")){
            switch (command){
                case "add" :
                    numbers = addCommand.apply(numbers);
                    break;
                case "multiply" :
                    numbers = multiplyCommand.apply(numbers);
                    break;
                case "subtract" :
                    numbers = substractCommand.apply(numbers);
                    break;
                case "print" :
                    printCommand.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
