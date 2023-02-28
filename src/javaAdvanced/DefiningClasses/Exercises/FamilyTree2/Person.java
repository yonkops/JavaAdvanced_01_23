package javaAdvanced.DefiningClasses.Exercises.FamilyTree2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthday;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(Person parents) {
        this.parents.add(parents);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(Person children) {
        this.children.add(children);
    }

    @Override
    public String toString() {
        String sb = this.name + " " + this.birthday + System.lineSeparator() +
                "Parents:" + System.lineSeparator() +
                listMembers(this.parents) + System.lineSeparator() +
                "Children:" + System.lineSeparator() +
                listMembers(this.children);
        return sb.trim();
    }

    private String listMembers (List<Person> personList){
        StringBuilder sb = new StringBuilder();
        for (Person person : personList){
            sb.append(System.lineSeparator());
            sb.append(String.format("%s %s", person.getName(),person.getBirthday()));
        }
        return sb.toString().trim();
    }
}
