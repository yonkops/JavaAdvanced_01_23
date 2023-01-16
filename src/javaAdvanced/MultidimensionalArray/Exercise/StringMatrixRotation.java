package javaAdvanced.MultidimensionalArray.Exercise;

import javaAdvanced.StacksAndQueues.Lab.BrowserHistoryUpgrade;

import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')')));
        char[][] charMatrix = getCharMatrix(scanner);
        printRotatedMatrix(charMatrix, degrees);
    }

    private static char[][] getCharMatrix(Scanner scanner) {
        String input;
        String[] matrix = new String[1000];
        input = scanner.nextLine();
        int matrixLength = 0;
        int matrixDimensionLength = 0;
        while (!input.equals("END")){
            matrix[matrixLength] = input;
            matrixLength++;
            if (matrixDimensionLength < input.length()) {
                matrixDimensionLength = input.length();
            }
            input = scanner.nextLine();
        }
        char[][] charMatrix = new char[matrixLength][matrixDimensionLength];
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixDimensionLength; j++) {
                try {
                    charMatrix[i][j] = matrix[i].charAt(j);
                } catch (StringIndexOutOfBoundsException exception){
                    charMatrix[i][j] = ' ';
                }
            }
        }
        return charMatrix;
    }

    private static void printRotatedMatrix (char[][] charMatrix, int degree) {
        int size = charMatrix[0].length - 1;
        degree %= 360;
        switch (degree){
            case 90 :
                // printed row = charMatrix.length; col = 0;
                for (int col = 0; col <= size; col++) {
                    for (int row = charMatrix.length - 1; row >= 0; row--) {
                        System.out.print(charMatrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180 :
                // printed row = charMatrix.length; col = charMatrix[0].length;
                for (int row = charMatrix.length - 1; row >= 0; row--) {
                    for (int col = charMatrix[row].length - 1; col >= 0; col--) {
                        System.out.print(charMatrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270 :
                // printed row = 0; col = charMatrix.length;
                for (int col = size; col >= 0; col--) {
                    for (int row = 0; row < charMatrix.length; row++) {
                        System.out.print(charMatrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 0 :
                // printed row = 0, col = 0
                for (int row = 0; row < charMatrix.length; row++) {
                    for (int col = 0; col < charMatrix[row].length; col++) {
                        System.out.print(charMatrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + degree);
        }


    }
}
