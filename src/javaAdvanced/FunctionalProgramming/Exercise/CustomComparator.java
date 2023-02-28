package javaAdvanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Comparator<Integer> comparator = ((first, second) -> {
            if (first % 2 == 0 && second % 2 != 0){
                return -1;
            } else if (first % 2 != 0 && second % 2 ==0) {
                return 1;
            } else {
                return first.compareTo(second);
            }
        });
        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}