package javaAdvanced.DefiningClasses.Exercises.CompanyRoster;

public class Employee {

//    name, salary, position, department, email, and age.
//    The name, salary, position, and department are mandatory,
//            while the rest are optional.
    private String name;
    private double salary;

    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.age = -1;
    }

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.email = "n/a";
        this.age = age;
    }

    public Employee(String name, double salary, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
