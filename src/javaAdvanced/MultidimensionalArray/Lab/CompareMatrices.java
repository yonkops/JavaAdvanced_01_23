package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = input(scanner);
        int[][] firstMatrix = fillMatrix(matrixSize, scanner);

        matrixSize = input(scanner);
        int[][] secondMatrix = fillMatrix(matrixSize, scanner);

        boolean areEqual = matrixAreEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static Boolean matrixAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] input (Scanner scanner){
        return Arrays.stream(scanner.nextLine().split("\\s++"))
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
}
