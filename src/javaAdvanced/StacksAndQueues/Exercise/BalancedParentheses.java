package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        char[] input = scanner.nextLine().toCharArray();
        boolean isBalanced = true;

        for (char current : input) {
            if (current == '(' || current == '{' || current == '['){
                parentheses.push(current);
            } else if (!parentheses.isEmpty()){
                char lastBracket = parentheses.pop();
                if (current == ')' && lastBracket != '('){
                    isBalanced = false;
                } else if (current == '}' && lastBracket != '{') {
                    isBalanced = false;
                } else if (current == ']' && lastBracket != '[') {
                    isBalanced = false;
                }
            } else {
                isBalanced = false;
            }
        }

        if (isBalanced && parentheses.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}