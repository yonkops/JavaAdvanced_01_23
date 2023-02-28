package javaAdvanced.DefiningClasses.Exercises.FamilyTree2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchedPerson = scanner.nextLine();
        Map<String, String> parentAndChild = new LinkedHashMap<>();
        Set<Person> personList = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            if (input.contains("-")){
                String parent = input.split(" - ")[0];
                String child = input.split(" - ")[1];
                parentAndChild.putIfAbsent(parent, child);
            } else {
                String[] splitData = input.split("\\s+");
                String name = splitData[0] + " " + splitData[1];
                String birthday = splitData[splitData.length - 1];
                Person person = new Person(name, birthday);
                personList.add(person);
            }
            input = scanner.nextLine();
        }

        for (String parent : parentAndChild.keySet()){
            String child = parentAndChild.get(parent);
            Person currentParent = findPerson(parent, personList);
            Person currentChild = findPerson(child, personList);
            Objects.requireNonNull(currentParent).setChildren(currentChild);
            Objects.requireNonNull(currentChild).setParents(currentParent);
        }
        if (!personList.isEmpty()){
            System.out.println(Objects.requireNonNull(findPerson(searchedPerson, personList)).toString().trim());
        }

    }

    private static Person findPerson(String input, Set<Person> personList) {
        for (Person person : personList){
            if (person.getBirthday().equals(input) || person.getName().equals(input)){
                return person;
            }
        }
        return null;
    }
}
