package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeOfMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix;
        matrix = fillMatrix(sizeOfMatrix[0], sizeOfMatrix[1], scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] command = input.split("\\s+");
            if (command[0].equals("swap") && command.length > 1){
                try {
                    int[] positions = new int[4];
                    for (int i = 1; i < command.length; i++) {
                        positions[i-1] = Integer.parseInt(command[i]);
                    }
                    String temp = matrix[positions[0]][positions[1]];
                    matrix[positions[0]][positions[1]] = matrix[positions[2]][positions[3]];
                    matrix[positions[2]][positions[3]] = temp;
                    printMatrix(matrix);
                } catch (IndexOutOfBoundsException | IllegalArgumentException ex1){
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static String[][] fillMatrix(int rowLength, int colLength, Scanner scanner) {
        String[][]matrix = new String[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
