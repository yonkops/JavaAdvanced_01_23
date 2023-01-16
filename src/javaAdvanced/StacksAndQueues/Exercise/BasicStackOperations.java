package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.size() == 0){
            System.out.println(0);
        } else {
            System.out.println(stack.contains(x) ? true : Collections.min(stack));
            // System.out.println(stack.stream().mapToInt(value -> value).min().getAsInt());
        }


    }
}
