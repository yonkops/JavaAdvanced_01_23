package javaAdvanced.MultidimensionalArray.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] matrixSize = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(matrixSize[0]);
        fillMatrix(matrixSize, matrix);
        input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")){
            int[] command = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int bombRow = command[0];
            int bombCol = command[1];
            int radius = command[2];
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if(i >= bombRow - radius && i <= bombRow + radius && j == bombCol){
                        matrix.get(i).set(j, -1);
                    }
                    if(j>= bombCol - radius && j<= bombCol + radius && i == bombRow){
                        matrix.get(i).set(j, -1);
                    }
                }
            }
            fixMatrix(matrix);
            input = scanner.nextLine();
        }
        printIntMatrix(matrix);
    }

    private static void fillMatrix(int[] matrixSize, ArrayList<ArrayList<Integer>> matrix) {
        int counter = 1;
        for (int i = 0; i < matrixSize[0]; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < matrixSize[1]; j++) {
                matrix.get(i).add(j, counter);
                counter++;
            }
        }
    }

    private static void fixMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).removeIf(el -> el.equals(-1));
            if (matrix.removeIf(e-> e.isEmpty())){
                i--;
            }

        }
    }

    private static void printIntMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
