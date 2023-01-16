package javaAdvanced.StacksAndQueues.Exercise;

import java.util.*;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");
        for (String num : input) {
            stack.push(num);
        }
        //System.out.println(String.join(" ", stack));
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }

    }
}
