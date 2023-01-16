package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixSize = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = getMatrix(matrixSize, scanner);
        System.out.println(matrixSize[0]);
        System.out.println(matrixSize[1]);
        printSumOfElements(matrix);
    }

    private static void printSumOfElements(int[][] matrix) {
        long sum = 0;
        for (int[] row : matrix) {
            for (int col : row) {
                sum += col;
            }
        }
        System.out.println(sum);
    }

    private static int[][] getMatrix(int[] matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
