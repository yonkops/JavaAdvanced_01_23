package javaAdvanced.ExamPreparation;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> foodPortion = new ArrayDeque<>();
        Deque<Integer> stamina = new ArrayDeque<>();
        ArrayDeque<Integer> peaksHeight = new ArrayDeque<>();
        ArrayDeque<String > peaksName = new ArrayDeque<>();
        peaksHeight.offer(80); peaksHeight.offer(90); peaksHeight.offer(100); peaksHeight.offer(60); peaksHeight.offer(70);
        peaksName.offer("Vihren"); peaksName.offer("Kutelo"); peaksName.offer("Banski Suhodol"); peaksName.offer("Polezhan"); peaksName.offer("Kamenitza");
        List<String> conqueredPeaks = new ArrayList<>();
        String[] input = scanner.nextLine().split(", ");
        for (String value : input){
            foodPortion.push(Integer.parseInt(value));
        }
        input = scanner.nextLine().split(", ");
        for (String value : input){
            stamina.offer(Integer.parseInt(value));
        }
        int daysTraveling = 7;
        while (!foodPortion.isEmpty() && !stamina.isEmpty() && daysTraveling > 0){
            daysTraveling--;
            if (peaksHeight.isEmpty()){
                break;
            }
            if (foodPortion.poll() + stamina.pop() >= peaksHeight.peek()){
                conqueredPeaks.add(peaksName.pop());
                peaksHeight.pop();
            }
        }
        if (peaksHeight.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
            System.out.println("Conquered peaks:");
            for (String mountain : conqueredPeaks) {
                System.out.println(mountain);
            }
        } else {
            System.out.println( "Alex failed! He has to organize his journey better next time -> @PIRINWINS");
            if (!conqueredPeaks.isEmpty()){
                System.out.println("Conquered peaks:");
                for (String mountain : conqueredPeaks) {
                    System.out.println(mountain);
                }
            }
        }
    }
}
