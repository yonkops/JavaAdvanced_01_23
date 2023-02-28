package javaOOP.WorkingWithAbstraction.Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getDimensions(scanner.nextLine());
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        fillMatrixValue(matrix);
        String command = scanner.nextLine();
        long stars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] peterDimension = getDimensions(command);
            command = scanner.nextLine();
            int[] evilDimension = getDimensions(command);
            evilCollectStars(matrix, evilDimension);
            stars += playerCollectStars(matrix, peterDimension);
            command = scanner.nextLine();
        }
        System.out.println(stars);
    }

    private static long playerCollectStars(int[][] matrix, int[] dimension) {
        int peterRow = dimension[0];
        int peterCol = dimension[1];
        long starsCollected = 0;
        while (peterRow >= 0 && peterCol < matrix[0].length) {
            if (peterRow < matrix.length && peterCol >= 0) {
                starsCollected += matrix[peterRow][peterCol];
            }
            peterRow --;
            peterCol ++;
        }
        return starsCollected;
    }

    private static void evilCollectStars(int[][] matrix, int[] dimensions) {
        int evilRow = dimensions[0];
        int evilCol = dimensions[1];
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length
                    && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow --;
            evilCol --;
        }
    }

    private static int[] getDimensions(String scanner) {
        return Arrays.stream(scanner
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static void fillMatrixValue(int[][] matrix) {
        int fieldValue = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = fieldValue++;
            }
        }
    }
}
