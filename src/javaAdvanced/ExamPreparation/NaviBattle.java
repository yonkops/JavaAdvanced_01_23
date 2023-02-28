package javaAdvanced.ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class NaviBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][];
        int rowShip = -1;
        int colShip = -1;
        int shipHealth = 3;
        int cruisers = 3;
        for (int i = 0; i < fieldSize; i++) {
            String input = scanner.nextLine();
            if (input.contains("S")){
                rowShip = i;
                colShip = input.indexOf("S");
            }
            field[i] = input.toCharArray();
        }
        while (shipHealth > 0 && cruisers > 0){
            String command = scanner.nextLine();
            field[rowShip][colShip] = '-';
            switch (command){
                    case "up" :
                        rowShip --;
                        break;
                    case "down" :
                        rowShip ++;
                        break;
                    case "left" :
                        colShip --;
                        break;
                    case "right" :
                        colShip ++;
                        break;
            }
            if (field[rowShip][colShip] == 'C'){
                cruisers --;
            } else if (field[rowShip][colShip] == '*') {
                shipHealth --;
            }
            field[rowShip][colShip] = 'S';
        }
        if (cruisers <= 0){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        } else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", rowShip, colShip);
        }
        for (char[] arr : field) {
            System.out.printf("", String.join("", Arrays.asList(field.toString().
                    substring(1, field.toString().length() - 1))));
            System.out.println();
        }
    }
}
