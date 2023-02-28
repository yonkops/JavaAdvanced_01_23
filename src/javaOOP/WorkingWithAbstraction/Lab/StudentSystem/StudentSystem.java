package javaOOP.WorkingWithAbstraction.Lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    public static final double EXCELLENT_SCORE = 5.00;
    public static final double AVERAGE_SCORE = 3.50;
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] args) {
        String firstArgument = args[0];
        String name = args[1];
        if (firstArgument.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            createStudent(name, age, grade);
        } else if (firstArgument.equals("Show")) {
            showStudent(name);
        }
    }

    private void showStudent(String name) {
        if (getRepo().containsKey(name)) {
            Student student = getRepo().get(name);
            double studentGrade = student.getGrade();
            StringBuilder output = new StringBuilder();
            output.append(String.format("%s is %s years old.", student.getName(), student.getAge()));
            if (studentGrade >= EXCELLENT_SCORE) {
                output.append(" Excellent student.");
            } else if (studentGrade < EXCELLENT_SCORE && studentGrade >= AVERAGE_SCORE) {
                output.append(" Average student.");
            } else {
                output.append(" Very nice person.");
            }
            System.out.println(output);
        }
    }

    private void createStudent(String name, int age, double grade) {
        Student student = new Student(name, age, grade);
        getRepo().putIfAbsent(name, student);
    }
}
