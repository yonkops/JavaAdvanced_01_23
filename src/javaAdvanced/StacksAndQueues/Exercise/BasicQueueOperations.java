package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        Deque<Integer> queue = new ArrayDeque<>();
        input = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if (queue.size() == 0){
            System.out.println(0);
        } else {
            System.out.println(queue.contains(x) ? true : Collections.min(queue));
            // System.out.println(queue.stream().mapToInt(value -> value).min().getAsInt());
        }


    }
}
