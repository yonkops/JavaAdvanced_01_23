package javaAdvanced.ExamPreparation.shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public int getCapacity() {
        return capacity;
    }

    public void add(Animal animal){
        if (data.size() < getCapacity()){
            data.add(animal);
        }
    }
    public boolean remove (String name){
        return data.removeIf(x -> x.getName().equals(name));
        /*for (Animal animal : data) {
            if (animal.getName().equals(name)){
                data.remove(animal);
                return true;
            }
        }
        return false;*/
    }
    public Animal getAnimal(String name, String caretaker){
        for (Animal animal : data){
            if (animal.getName().equals(name)
                    && animal.getCaretaker().equals(caretaker)){
                return animal;
            }
        }
        return null;
    }
    public Animal getOldestAnimal(){
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).get();
        /*Animal oldestAnimal = null;
        for (Animal animal : data){
            if (oldestAnimal == null || oldestAnimal.getAge() < animal.getAge()){
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;*/
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:");
        for (Animal animal : data) {
            sb.append(System.lineSeparator());
            sb.append(animal.getName()).append(" ")
                    .append(animal.getCaretaker());
        }
        return sb.toString();
    }

}
