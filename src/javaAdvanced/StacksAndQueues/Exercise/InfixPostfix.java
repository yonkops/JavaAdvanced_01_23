package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class InfixPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        //String[] input = "( 3 + x ) - y".split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> operands = new ArrayDeque<>();

        for (String current : input) {
            if (current.matches("\\w+")) {
                queue.offer(current);
            } else {
                if (operands.isEmpty()) {
                    operands.push(current);
                } else {
                    String lastOperator = operands.peek();
                    switch (current) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operands.push(current);
                            } else {
                                queue.offer(operands.pop());
                                operands.push(current);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                queue.offer(operands.pop());
                                operands.push(current);
                            } else {
                                operands.push(current);
                            }
                            break;
                        case "(":
                            operands.push(current);
                            break;
                        case ")":
                            while (!operands.peek().equals("(")) {
                                queue.offer(operands.pop());
                            }
                            operands.pop();
                            break;
                    }
                }
            }
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        while (!operands.isEmpty()){
            System.out.print(operands.pop() + " ");
        }

    }
}
