package javaAdvanced.SetAndMaps.Lab;

import java.sql.SQLOutput;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentsGrades = new TreeMap<>();
        int nInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < nInputs; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);
            if (!studentsGrades.containsKey(name)){
                studentsGrades.put(name, new ArrayList<>());
                studentsGrades.get(name).add(grade);
            } else {
                studentsGrades.get(name).add(grade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {

            System.out.print(entry.getKey() + " -> ");
            double sumOfGrades = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                sumOfGrades += grade;
            }

            System.out.printf("(avg: %.2f)%n", sumOfGrades / entry.getValue().size());
        }
    }
}
