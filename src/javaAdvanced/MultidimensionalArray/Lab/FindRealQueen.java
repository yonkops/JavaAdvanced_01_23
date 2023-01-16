package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Scanner;

public class FindRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = 8;
        char[][] matrix = getMatrix(matrixSize, scanner);
        boolean isRealQueen;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q'){
                    isRealQueen = checkForQueens(matrix, row, col);
                    if (!isRealQueen) {
                        System.out.println(row + " " + col);
                        break;
                    }
                }
            }
        }

    }

    private static boolean checkForQueens(char[][] matrix, int row, int col) {
        // check right to left diagonal - Ok
        for (int i = 1; i < matrix.length; i++) {
            if((row + i) < matrix.length && (col + i) < matrix.length){
                if (matrix[row + i][col + i] == 'q'){
                    return true;
                }
            }
            if ((row - i) >= 0 && (col - i) >= 0){
                if (matrix[row - i][col - i] == 'q'){
                    return true;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if((row + i) < matrix.length && (col - i) >= 0){
                if (matrix[row + i][col - i] == 'q'){
                    return true;
                }
            }
            if ((row - i) >= 0 && (col + i) < matrix.length){
                if (matrix[row - i][col + i] == 'q'){
                    return true;
                }
            }
        }

        // check Horizontal
        for (int i = 1; i < matrix.length; i++) {
            if((row + i) < matrix.length){
                if (matrix[row + i][col] == 'q'){
                    return true;
                }
            }
            if ((row - i) >= 0){
                if (matrix[row - i][col] == 'q'){
                    return true;
                }
            }
        }
        // Test Vertical
        for (int i = 1; i < matrix.length; i++) {
            if((col + i) < matrix.length){
                if (matrix[row][col + i] == 'q'){
                    return true;
                }
            }
            if ((col - i) >= 0){
                if (matrix[row][col - i] == 'q'){
                    return true;
                }
            }
        }
        return false;
    }

    private static char[][] getMatrix(int matrixSize, Scanner scanner) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col].charAt(0);
            }
        }
        return matrix;
    }
}
