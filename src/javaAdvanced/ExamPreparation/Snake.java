package javaAdvanced.ExamPreparation;

import java.util.ArrayList;
import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[fieldSize][];
        ArrayList<Integer> lairPositions = new ArrayList<>();
        int rowSnake = -1;
        int colSnake = -1;
        for (int i = 0; i < fieldSize; i++) {
            String input = scanner.nextLine();
            field[i] = input.toCharArray();
            int indexOfS = input.indexOf("S");
            if (indexOfS > -1) {
                rowSnake = i;
                colSnake = indexOfS;
            } else {
                checkForLairCoordinates(lairPositions, i, input);
            }
        }
        int eatenFood = 0;
        boolean isInField = true;
        // Snake Movement
        while (eatenFood < 10 && isInField){
            int row = rowSnake;
            int col = colSnake;
            String command = scanner.nextLine();
            field[rowSnake][colSnake] = '.';
            switch (command){
                case "up" : row --; break;
                case "down" : row ++; break;
                case "left" : col --; break;
                case "right" : col ++; break;
            }
            isInField = isValidPosition(row, col, fieldSize);
            if (isInField) {
                rowSnake = row;
                colSnake = col;
                if (field[rowSnake][colSnake] == 'B'){
                    field[rowSnake][colSnake] = '.';
                    if (rowSnake == lairPositions.get(0) && colSnake == lairPositions.get(1)){
                        rowSnake = lairPositions.get(2);
                        colSnake = lairPositions.get(3);
                    } else {
                        rowSnake = lairPositions.get(0);
                        colSnake = lairPositions.get(1);
                    }
                } else if (field[rowSnake][colSnake] == '*') {
                    eatenFood++;
                }
                field[rowSnake][colSnake] = 'S';
            }

        }
        if (eatenFood >= 10){
            System.out.println("You won! You fed the snake.");
        } else if (!isInField) {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + eatenFood);

        printMatrix(field);

    }

    private static void checkForLairCoordinates(ArrayList<Integer> lairPositions, int row, String input) {
        int indexOfB = input.indexOf("B");
        if (indexOfB > -1) {
            if(indexOfB == input.lastIndexOf("B")) {
                lairPositions.add(row);
                lairPositions.add(indexOfB);
            } else {
    // if they are on same row
                lairPositions.add(row);
                lairPositions.add(indexOfB);
                lairPositions.add(row);
                lairPositions.add(input.lastIndexOf("B"));
            }
        }
    }
    private static boolean isValidPosition(int row, int col, int fieldSize){
        return row < fieldSize
                && col < fieldSize
                && row >= 0
                && col >= 0;
    }
    private static void printMatrix(char[][] field) {
        for (char[] arr : field) {
            for (char ch : arr){
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
