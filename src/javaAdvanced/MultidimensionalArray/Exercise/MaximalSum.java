package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeOfMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix;
        matrix = fillMatrixA(sizeOfMatrix[0], sizeOfMatrix[1], scanner);
        int maxSum = Integer.MIN_VALUE;
        int[][] subMatrix = new int[3][3];
        int rowLength = matrix.length - 3;
        int colLength = matrix[0].length - 3;

        for (int row = 0; row <= rowLength; row++) {
            for (int col = 0; col <= colLength; col++) {
                int[][] testMatrix = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    System.arraycopy(matrix[i + row], col, testMatrix[i], 0, 3 );
                }
                int currentSum = getCurrentSum(testMatrix);
                if (maxSum < currentSum){
                    maxSum = currentSum;
                    subMatrix = testMatrix;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(subMatrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static int getCurrentSum(int[][] testMatrix) {
        int sum = 0;
        for (int i = 0; i < testMatrix.length; i++) {
            for (int j = 0; j < testMatrix[i].length; j++) {
                sum += testMatrix[i][j];
            }
        }
        return sum;
    }


    private static int[][] fillMatrixA(int rowLength, int colLength, Scanner scanner) {
        int[][]matrix = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
