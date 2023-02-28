package javaAdvanced.DefiningClasses.Exercises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Department> departmentsList = new ArrayList<>();
        int employeesNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeesNumber; i++) {
            // {name, salary, department 2, email, age
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String department = data[3];
            String email;
            Employee currentEmployee;
            int age;
            if (data.length == 6){
                email = data[4];
                age = Integer.parseInt(data[5]);
                currentEmployee = new Employee(name, salary, email, age);
            } else if (data.length == 5) {
                if (Character.isDigit(data[4].charAt(0))){
                    age = Integer.parseInt(data[4]);
                    currentEmployee = new Employee(name, salary, age);
                } else {
                    email = data[4];
                    currentEmployee = new Employee(name, salary, email);
                }
            } else {
                currentEmployee = new Employee(name, salary);
            }
            Department departmentClass = new Department(department, currentEmployee);

            if (!isDepartmentExist(departmentsList, department)){
                departmentsList.add(departmentClass);
            } else {
                for (Department dp : departmentsList) {
                    if (dp.getName().equals(department)) {
                        dp.setEmployeeToList(currentEmployee);
                        break;
                    }
                }
            }
        }
        double maxAverage = Double.MIN_VALUE;
        String maxSalaryDepartment = "";
        for(Department dp : departmentsList){
            double averageSalary = dp.getAverageSalary(dp);
            if(averageSalary > maxAverage){
                maxAverage = averageSalary;
                maxSalaryDepartment = dp.getName();
            }
        }
        System.out.println("Highest Average Salary: " + maxSalaryDepartment);
        for (Department dp : departmentsList) {
            if (dp.getName().equals(maxSalaryDepartment)) {
                dp.printSortedDescendingBySalary();
            }
        }

    }

    private static boolean isDepartmentExist(List<Department> departmentsList, String department) {
        for(Department dp : departmentsList){
            if(dp.getName().equals(department)){
                return true;
            }
        }
        return false;
    }
}
