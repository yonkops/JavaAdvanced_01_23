package javaAdvanced.MultidimensionalArray.Lab;

public class LiveLab {
    private static void printMatrix(int[][] firstMatrix) {
        for ( int[] number : firstMatrix) {
            for (int point: number) {
                System.out.print(point + " ");
            }
            System.out.println();
        }
    }

}
