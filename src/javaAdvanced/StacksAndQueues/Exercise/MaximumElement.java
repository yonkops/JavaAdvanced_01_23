package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque();
        int commandsNumber = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < commandsNumber; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (Integer.parseInt(command[0])){
                case 1 :

                    stack.push(Integer.parseInt(command[1]));
                    break;
                case 2 :
                    stack.pop();
                    break;
                case 3 :
                    System.out.println(Collections.max(stack));
                    break;
            }
        }

    }

}
