package javaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(20); // Add Element to the top
        stack.peek(); // returns the top element without remove it
        stack.pop(); // return element and removes it

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(20); // Add element to the end
        queue.peek(); //return front element in the queue
        queue.poll(); // return front element and remove it

        long[] input = Arrays.stream(scanner.nextLine().split(":")).mapToLong(Long::parseLong).toArray();

    }
}
