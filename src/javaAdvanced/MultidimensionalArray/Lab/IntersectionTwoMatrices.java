package javaAdvanced.MultidimensionalArray.Lab;


import java.util.Scanner;

public class IntersectionTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixCols = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix;
        char[][] secondMatrix;
        char[][] modifiedMatrix = new char[matrixRows][matrixCols];

        firstMatrix = fillMatrix(matrixRows, matrixCols, scanner);
        secondMatrix = fillMatrix(matrixRows, matrixCols, scanner);

        modifyChars(firstMatrix, secondMatrix, modifiedMatrix);
        printMatrix(modifiedMatrix);

    }

    private static void modifyChars(char[][] firstMatrix, char[][] secondMatrix, char[][] modifiedMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int cols = 0; cols < firstMatrix[row].length; cols++) {
                if (firstMatrix[row][cols] == secondMatrix[row][cols]){
                    modifiedMatrix[row][cols] = firstMatrix[row][cols];
                } else {
                    modifiedMatrix[row][cols] = '*';
                }

            }
        }
    }

    public static char[][] fillMatrix (int rows, int cols, Scanner scanner){
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = elements[col].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for ( char[] rows : matrix) {
            for (char point: rows) {
                System.out.print(point + " ");
            }
            System.out.println();
        }
    }

}
