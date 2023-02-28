package javaAdvanced.Exam_18_02_2023;

import java.util.Arrays;
import java.util.Scanner;

public class matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] fieldSize = Arrays.stream(Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()).toArray();
        char[][] field = new char[fieldSize[0]][fieldSize[1]];
        int playerRow = -1;
        int playerCol = -1;
        int kidsOnPlayground = 0;
        int kidsTouched = 0;
        int stepsMade = 0;
        for (int i = 0; i < fieldSize[0]; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            field[i] = input.toCharArray();
            int indexOfPlayer = input.indexOf("B");
            if (indexOfPlayer >= 0) {
                playerRow = i;
                playerCol = indexOfPlayer;
            }
            int indexOfOpponents = input.indexOf("P");
            if (indexOfOpponents >= 0) {
                for (char ch : input.toCharArray()) {
                    if (ch == 'P'){
                        kidsOnPlayground ++;
                    }
                }

            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Finish") && kidsOnPlayground > 0){
            int row = playerRow;
            int col = playerCol;
            field[playerRow][playerCol] = '-';
            switch (command){
                case "up" : row --; break;
                case "down" : row ++; break;
                case "left" : col --; break;
                case "right" : col ++; break;
            }
            if (isValidPosition(row, col, fieldSize[0], fieldSize[1]) && field[row][col] != 'O'){
                playerRow = row;
                playerCol = col;
                if (field[playerRow][playerCol] == 'P'){
                    kidsOnPlayground --;
                    kidsTouched ++;
                }
                stepsMade ++;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", kidsTouched, stepsMade);
    }

    //Check for valid position -> return true if is on field
    private static boolean isValidPosition(int row, int col, int maxRow, int maxCol){
        return row < maxRow
                && col < maxCol
                && row >= 0
                && col >= 0;
    }

}
