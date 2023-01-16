package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int[][] squareMatrix;
        squareMatrix = fillMatrix(sizeOfMatrix,scanner);
        diagonalDifference(squareMatrix);
        
    }

    private static int[][] fillMatrix(int sizeOfMatrix, Scanner scanner) {
        int[][]matrix = new int[sizeOfMatrix][sizeOfMatrix];
        for (int row = 0; row < sizeOfMatrix; row++) {
            for (int col = 0; col < sizeOfMatrix; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
    private static void diagonalDifference(int[][] matrix){
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int differences;
        int matrixSize = matrix.length - 1;
        for (int i = 0; i <= matrixSize; i++) {
            primaryDiagonal += matrix[i][i];
            secondaryDiagonal += matrix[matrixSize - i][i];
        }
        differences = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(differences);

    }
}
