package javaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (input == 0){
            System.out.println(input);
        } else {

            while (input != 0) {
                stack.push(input % 2);
                input /= 2;
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
