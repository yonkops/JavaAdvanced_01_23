package javaAdvanced.ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();
        int distance = 0;
        int rowCar = 0;
        int colCar = 0;
        boolean finishedRace = false;
        ArrayList<Integer> tunnelPositions = new ArrayList<>();
        char[][] field = new char[fieldSize][];
        fillMatrixAndSetTunnelPosition(scanner, fieldSize, tunnelPositions, field);
        String command = scanner.nextLine();
        while (!command.equals("End")){
            field[rowCar][colCar] = '.';
            switch (command){
                case "up" :
                    rowCar --;
                    break;
                case "down" :
                    rowCar ++;
                    break;
                case "left" :
                    colCar --;
                    break;
                case "right" :
                    colCar ++;
                    break;
            }
            if (field[rowCar][colCar] == 'T'){
                // Go to next tunnel
                field[rowCar][colCar] = '.';
                rowCar = tunnelPositions.get(2);
                colCar = tunnelPositions.get(3);
                distance += 30;
            } else if (field[rowCar][colCar] == 'F') {
                // Finish Race
                System.out.printf("Racing car %s finished the stage!%n", racingNumber);
                finishedRace = true;
                distance += 10;
                break;
            } else {
                distance += 10;
            }

            command = scanner.nextLine();
        }
        field[rowCar][colCar] = 'C';
        if (!finishedRace){
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }
        System.out.printf("Distance covered %d km.%n", distance);
        for (char[] arr : field){
            for (char ch : arr){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    private static void fillMatrixAndSetTunnelPosition(Scanner scanner, int fieldSize, ArrayList<Integer> tunnelPositions, char[][] field) {
        for (int i = 0; i < fieldSize; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            field[i] = input.toCharArray();
            if (input.contains("T")){
                tunnelPositions.add(i);
                tunnelPositions.add(input.indexOf("T"));
            }
        }
    }
}
