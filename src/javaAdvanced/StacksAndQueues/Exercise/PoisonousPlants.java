package javaAdvanced.StacksAndQueues.Exercise;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Long> plantsStack = new ArrayDeque<>();
        ArrayDeque<Long> tempQueue = new ArrayDeque<>();
        int plantsNumber = Integer.parseInt(scanner.nextLine());
        for (long i = 0L; i < plantsNumber; i++) {
            plantsStack.push(scanner.nextLong());
        }
        long daysCounter = 0L;
        boolean haveDeathPlants = true;
        while (haveDeathPlants){
            haveDeathPlants = false;
            while (!plantsStack.isEmpty()) {
                long current = plantsStack.pop();
                if (!plantsStack.isEmpty()){
                    long nextPlant = plantsStack.pop();
                    // !10 < 7
                    if (current < nextPlant){
                        tempQueue.offer(current);
                        plantsStack.push(nextPlant);
                    } else if (current > nextPlant){
                        haveDeathPlants = true;
                        plantsStack.push(nextPlant);
                    } else {
                        tempQueue.offer(current);
                        plantsStack.push(nextPlant);
                    }

                } else {
                    tempQueue.offer(current);
                    continue;
                }
            }
            if (haveDeathPlants){
                daysCounter++;
            }


            plantsStack = tempQueue;
            tempQueue = new ArrayDeque<>();
        }
        System.out.println(daysCounter);
    }


}
