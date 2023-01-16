package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[matrixSize][];

        for (int i = 0; i < matrixSize; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] correctedMatrix = new int[matrix.length][matrix[0].length];
        int[] wrongNumberPosition = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongNumber = matrix[wrongNumberPosition[0]][wrongNumberPosition[1]];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == wrongNumber){
                    int sum = 0;
                    // check left number row, col - 1
                    if (col - 1 >= 0 && matrix[row][col-1] != wrongNumber){
                         sum += matrix[row][col - 1];
                    }
                    // check up number row - 1, col
                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber){
                        sum += matrix[row - 1][col];
                    }
                    // check right number row, col + 1
                    if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber){
                        sum += matrix[row][col + 1];
                    }
                    // check down number row + 1, col
                    if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber){
                        sum += matrix[row + 1][col];
                    }
                    if (sum > 0){
                        correctedMatrix[row][col] = sum;
                    }

                } else {
                    correctedMatrix[row][col] = matrix[row][col];
                }

            }
        }

        printIntMatrix(correctedMatrix);
    }

    private static void printIntMatrix(int[][] correctedMatrix) {
        for (int[] rows : correctedMatrix) {
            for (int number : rows) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
