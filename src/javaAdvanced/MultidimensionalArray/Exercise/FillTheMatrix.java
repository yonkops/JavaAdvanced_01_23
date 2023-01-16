package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int sizeOfMatrix = Integer.parseInt(input[0]);
        char command = input[1].charAt(0);
        int[][] matrix;
        if (command == 'A'){
            matrix = fillMatrixA(sizeOfMatrix);
        } else {
            matrix = fillMatrixB(sizeOfMatrix);
        }
        printMatrix(matrix);
    }

    private static int[][] fillMatrixA(int sizeOfMatrix) {
        int currentNumber = 1;
        int[][]matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int col = 0; col < sizeOfMatrix; col++) {
            for (int row = 0; row < sizeOfMatrix; row++) {
                matrix[row][col] = currentNumber;
                currentNumber++;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixB(int sizeOfMatrix) {
        int currentNumber = 1;
        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = currentNumber;
                    currentNumber++;
                }
            } else {
                for (int backRow = matrix.length - 1; backRow >= 0; backRow--) {
                    matrix[backRow][col] = currentNumber;
                    currentNumber++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
