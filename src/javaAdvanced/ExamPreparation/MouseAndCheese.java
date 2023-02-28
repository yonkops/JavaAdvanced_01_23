package javaAdvanced.ExamPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[matrixSize][];
        fillMatrix(scanner, field);
        int[] mousePosition = findMouse(field);
        String directions = scanner.nextLine();
        int eatenCheese = 0;
        int rowMouse = mousePosition[0];
        int colMouse = mousePosition[1];
        while (!directions.equals("end")){
            field[rowMouse][colMouse] = '-';
            switch(directions){
                case "up" :
                    rowMouse --;
                    break;
                case "down" :
                    rowMouse ++;
                    break;
                case "left" :
                    colMouse --;
                    break;
                case "right" :
                    colMouse ++;
                    break;
            }
            if (colMouse < 0 || colMouse >= matrixSize || rowMouse < 0 || rowMouse >= matrixSize){
                System.out.println("Where is the mouse?");
                break;
            }
            if (field[rowMouse][colMouse] == 'c'){
                eatenCheese++;
            } else if (field[rowMouse][colMouse] == 'B') {
                continue;
            }
            field[rowMouse][colMouse] = 'M';
            directions = scanner.nextLine();
        }
        if (eatenCheese >= 5){
            System.out.printf("Great job, the mouse is fed %d cheeses!", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.", (5 - eatenCheese));
        }
        printMatrix(field);
    }

    private static void printMatrix(char[][] matrix) {
        System.out.println();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] findMouse(char[][] field) {
        int[] mousePosition = new int[]{-1, -1};
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                char currentSymbol = field[row][col];
                if (currentSymbol == 'M') {
                    mousePosition = new int[]{row, col};
                }
            }
        }
        return mousePosition;
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String rowContent = scanner.nextLine();
            char [] rowSymbols = rowContent.toCharArray();
            matrix[row] = rowSymbols;
        }
    }
}
