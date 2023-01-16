package javaAdvanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = getMatrix(matrixSize, scanner);

        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = matrix.length - 1; row >= 0; row--) {
            int col = (matrix.length - 1) - row;
            System.out.print(matrix[row][col] + " ");
        }

    }


    private static int[][] getMatrix(int matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
