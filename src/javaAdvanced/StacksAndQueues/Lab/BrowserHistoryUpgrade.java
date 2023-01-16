package javaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String currentUrl = null;
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!input.equals("Home")){
            if (input.equals("back")){
                if (history.isEmpty()){
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    forwardHistory.push(currentUrl);
                    currentUrl = history.pop();
                }

            } else if (input.equals("forward")){
                if (forwardHistory.isEmpty()){
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    history.push(currentUrl);
                    currentUrl = forwardHistory.pop();
                }

            } else {
                if (currentUrl != null) {
                    history.push(currentUrl);
                    forwardHistory.clear();
                }
                currentUrl = input;
            }

            System.out.println(currentUrl);

            input = scanner.nextLine();

        }
    }
}
