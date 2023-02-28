package javaAdvanced.ExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int matrixRow = scanner.nextInt();
        int matrixCol = scanner.nextInt();
        scanner.nextLine();
        List<String> path = new ArrayList<>();
        char[][] field = new char[matrixRow][];
        int rowPosition = -1;
        int colPosition = -1;
        boolean isFound = false;
        for (int i = 0; i < matrixRow; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            field[i] = input.toCharArray();
            //finding player position
            if (input.contains("Y")){
                rowPosition = i;
                colPosition = input.indexOf("Y");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Finish")){
            field[rowPosition][colPosition] = '-';
            int row = rowPosition;
            int col = colPosition;
            switch (command){
                case "up" :
                    row --;
                    break;
                case "down" :
                    row ++;
                    break;
                case "left" :
                    col --;
                    break;
                case "right" :
                    col ++;
                    break;
            }
            if (row >= matrixRow || col >= matrixCol || row < 0 || col < 0 || field[row][col] == 'T'){
                command = scanner.nextLine();
                continue;
            } else {
                rowPosition = row;
                colPosition = col;
                path.add(command);
                if (field[rowPosition][colPosition] == 'X'){
                    // Found Treasure
                    isFound = true;
                    break;
                }
            }
            command = scanner.nextLine();
        }
        if (isFound){
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", Arrays.asList(path.toString().
                    substring(1, path.toString().length() - 1))));
        } else {
            System.out.println("The map is fake!");
        }

    }

}
