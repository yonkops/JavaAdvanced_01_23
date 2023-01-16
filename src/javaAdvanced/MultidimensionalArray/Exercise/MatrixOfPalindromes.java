package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int [] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] palindromes = new String[size[0]][size[1]];
        char first = 'a';
        char middle = 'a';
        for (int i = 0; i < palindromes.length; i++) {
            for (int j = 0; j < palindromes[i].length; j++) {
                palindromes[i][j] = "" + first + middle + first;
                middle++;
            }
            first++;
            middle = first;
        }
        printMatrix(palindromes);
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
