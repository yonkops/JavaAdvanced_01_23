package javaAdvanced.StacksAndQueues.Lab;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids  = scanner.nextLine().split("\\s+");
        int nTurns = scanner.nextInt();
        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, kids);

        int nextKid = 1;

        while (queue.size() > 1){
            String kid = queue.poll();
            if (nextKid % nTurns == 0) {
                System.out.println("Removed " + kid);
            } else {
                queue.offer(kid);
            }
            nextKid ++;
        }
        System.out.println("Last is " + queue.poll());
    }
}
