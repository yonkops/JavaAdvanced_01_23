package javaAdvanced.ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class Bombs {
    private static final int CHERRY_BOMB_VALUE = 60;
    private static final int DATURA_BOMB_VALUE = 40;
    private static final int SMOKE_BOMB_VALUE = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(bombEffects::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(bombCasings::push);
        int cherryBombs = 0, daturaBombs = 0, smokeBombs = 0;
        boolean checkSuccess = false;
        while (!bombEffects.isEmpty() && !bombCasings.isEmpty() && !checkSuccess){
            if (cherryBombs >= 3 && daturaBombs >= 3 && smokeBombs >= 3){
                // end
                checkSuccess = true;
                continue;
            }
            int effect = bombEffects.pop();
            int casing = bombCasings.poll();
            int sumValues = effect + casing;
            if (sumValues == SMOKE_BOMB_VALUE){
                smokeBombs ++;
                continue;
            } else if (sumValues == CHERRY_BOMB_VALUE) {
                cherryBombs ++;
                continue;
            } else if (sumValues == DATURA_BOMB_VALUE) {
                daturaBombs ++;
                continue;
            } else {
                bombEffects.offerFirst(effect);
                bombCasings.offerFirst(casing - 5);
            }

        }
        if (checkSuccess){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        printDeque(bombEffects, bombCasings);
        System.out.printf("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d",
                cherryBombs, daturaBombs,smokeBombs);
    }

    private static void printDeque(ArrayDeque<Integer> bombEffects, ArrayDeque<Integer> bombCasings) {
        if (!bombEffects.isEmpty()) {
            System.out.printf(
                    "Bomb Effects: %s%n", String.join(", ", Arrays.asList(bombEffects.toString())).substring(1, bombEffects.toString().length() - 1));
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!bombCasings.isEmpty()) {
            System.out.printf(
                    "Bomb Casings: %s%n", String.join(", ", Arrays.asList(bombCasings.toString())).substring(1, bombCasings.toString().length() - 1));
        } else {
            System.out.println("Bomb Casings: empty");
        }
    }
}
