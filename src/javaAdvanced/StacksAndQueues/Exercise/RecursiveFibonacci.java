package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        fibonacci.push(0L);
        fibonacci.push(1L);
        int fibonacciN = Integer.parseInt(scanner.nextLine());
        long result;
        if (fibonacciN == 0){
            result = 0;
        } else {
            for (int i = 0; i < fibonacciN; i++) {
                long firstN = fibonacci.pop();
                long secondN = fibonacci.pop();
                fibonacci.push(firstN);
                fibonacci.push(firstN + secondN);
            }
            result = fibonacci.pop();
        }
        System.out.println(result);

    }
}
