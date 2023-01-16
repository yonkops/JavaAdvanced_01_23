package javaAdvanced.StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String printCommand = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
            while (!printCommand.equals("print")){
                if (printCommand.equals("cancel")){
                    if (queue.isEmpty()){
                        System.out.println("Printer is on standby");
                    } else {
                        System.out.println("Canceled " + queue.poll());
                    }
                } else {
                    queue.offer(printCommand);
                }

                printCommand = scanner.nextLine();


            }
            while (!queue.isEmpty()){
                System.out.println(queue.poll());
            }


    }
}
