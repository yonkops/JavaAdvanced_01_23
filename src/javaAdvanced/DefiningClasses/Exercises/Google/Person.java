package javaAdvanced.DefiningClasses.Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    private String printCompany(Company company){
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append(System.lineSeparator());
        if (company != null){
            sb.append(company.getCompanyName()).append(" ")
                    .append(company.getDepartment()).append(" ")
                    .append(String.format("%.2f",company.getSalary())).append(System.lineSeparator());
        }
        return sb.toString();
    }
    private String printCar(Car car){
        StringBuilder sb = new StringBuilder();
        sb.append("Car:").append(System.lineSeparator());
        if (car != null){
            sb.append(car.getCarModel()).append(" ")
                    .append(car.getCarSpeed()).append(System.lineSeparator());
        }
        return sb.toString();

    }
    private String printPokemon(List<Pokemon> pokemon){
        StringBuilder sb = new StringBuilder();
        sb.append("Pokemon:").append(System.lineSeparator());
        if (pokemon != null){
            for (Pokemon pokemon1 : pokemon){
                sb.append(pokemon1.getPokemonName()).append(" ")
                        .append(pokemon1.getPokemonType()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    private String printParents(List<Parent> parent){
        StringBuilder sb = new StringBuilder();
        sb.append("Parents:").append(System.lineSeparator());
        if (parent != null){
            for (Parent parent1 : parent){
                sb.append(parent1.getParent()).append(" ")
                        .append(parent1.getParentBirthday()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
    private String printChild(List<Children> children){
        StringBuilder sb = new StringBuilder();
        sb.append("Children:").append(System.lineSeparator());
        if (children != null){
            for (Children children1 : children){
                sb.append(children1.getChildName()).append(" ")
                        .append(children1.getChildBirthday()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.name).append(System.lineSeparator());
            sb.append(printCompany(this.company));
            sb.append(printCar(this.car));
            sb.append(printPokemon(this.pokemon));
            sb.append(printParents(this.parents));
            sb.append(printChild(this.children));
        return sb.toString();
    }
}
