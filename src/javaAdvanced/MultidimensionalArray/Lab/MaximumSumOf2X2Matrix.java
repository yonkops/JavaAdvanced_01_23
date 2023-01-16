package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = getMatrix(matrixSize, scanner);

        long maxSum = Integer.MIN_VALUE;
        String subMatrix = "";
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (maxSum < sum){
                    maxSum = sum;
                    subMatrix = (matrix[row][col] + " ")
                            + (matrix[row][col+ 1] + " \n")
                            + (matrix[row + 1][col] + " ")
                            + (matrix[row + 1][col + 1] + " ");
                }
            }
        }

        System.out.println(subMatrix);
        System.out.println(maxSum);

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
