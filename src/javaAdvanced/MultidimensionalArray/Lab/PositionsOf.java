package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Scanner;

import static java.util.Arrays.*;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = input(scanner);
        int[][] matrixIn = fillMatrix(matrixSize, scanner);
        int searchedNumber = scanner.nextInt();

        searchInMatrix(matrixIn, searchedNumber);
    }


    public static int[] input (Scanner scanner){
        return stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int [][] fillMatrix (int[] matrixSize, Scanner scanner){
        int matrixRow = matrixSize[0];
        //int matrixCols = matrixSize[1];
        int[][] matrix = new int[matrixRow][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input(scanner);
        }
        return matrix;
    }

    private static void searchInMatrix(int[][] matrix, int searchedN) {
        boolean exist = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentN = matrix[row][col];
                if (searchedN == currentN){
                    exist = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!exist){
            System.out.println("not found");
        }
    }
}
