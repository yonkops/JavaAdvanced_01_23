package javaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque();
        Collections.addAll(stack, input);
        String currentSymbol = null;
        int result = 0;
        String symbol = "";
        while (!stack.isEmpty()){
            currentSymbol = stack.pop();
            switch (currentSymbol){
                case "+" :
                    symbol = "+";
                    break;
                case "-" :
                    symbol = "-";
                    break;
                default:
                    if (symbol.equals("-")){
                        result -= Integer.parseInt(currentSymbol);
                    } else {
                        result += Integer.parseInt(currentSymbol);
                    }
            }
        }
        System.out.println(result);

    }
}
