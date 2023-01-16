package javaAdvanced.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        int commandsNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsNumber; i++) {
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);
            switch (command){
                case 1 :
                    String string = input[1];
                    stack.push(text.toString());
                    text.append(string);
                    break;
                case 2 :
                    stack.push(text.toString());
                    int count = Integer.parseInt(input[1]);
                    text.delete(text.length() - count, text.length());
                    break;
                case 3 :
                    int index = Integer.parseInt(input[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4 :
                    text = new StringBuilder(stack.pop());
                    break;

            }
        }
    }
}
