package javaAdvanced.ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");
        int totalMoney = 0;
        int rowThief = -1;
        int colThief = -1;
        String[][] field = new String[matrixSize][];
        for (int i = 0; i < matrixSize; i++) {
            field[i] = scanner.nextLine().split("\\s+");
            int position = Arrays.asList(field[i]).indexOf("D");
            if (position != -1 ){
                rowThief = i;
                colThief = position;
            }
        }
        for (String command : directions){
            switch (command){
                case "up" :
                    if (rowThief - 1 < 0){
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        field[rowThief][colThief] = "+";
                        rowThief --;
                    }
                    break;
                case "down" :
                    if (rowThief + 1 >= matrixSize){
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        field[rowThief][colThief] = "+";
                        rowThief ++;
                    }
                    break;
                case "right" :
                    if (colThief + 1 >= matrixSize){
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        field[rowThief][colThief] = "+";
                        colThief ++;
                    }
                    break;
                case "left" :
                    if (colThief - 1 < 0){
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        field[rowThief][colThief] = "+";
                        colThief --;
                    }
                    break;
            }
            String position = field[rowThief][colThief];
            if (position.equals("$")){
                int stolenMoney = rowThief * colThief;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
                totalMoney += stolenMoney;
                field[rowThief][colThief] = "D";
            } else if (position.equals("P")){
                field[rowThief][colThief] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                printMatrix(field);
                return;
            } else if (position.equals("+")){
                field[rowThief][colThief] = "D";
            }
        }
        System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        printMatrix(field);
    }

    private static void printMatrix(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }
}
