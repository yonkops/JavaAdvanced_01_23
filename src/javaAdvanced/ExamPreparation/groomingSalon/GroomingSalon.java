package javaAdvanced.ExamPreparation.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Pet pet){
        if(getCount()< capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        for(Pet pet: data){
            if(pet.getName().equals(name)){
                this.data.remove(pet);

                return true;
            }
        }return false;
    }
    public Pet getPet(String name, String owner){
        for (Pet pet: data){
            if(pet.getName().equals(name) &&
            pet.getOwner().equals(owner)){
              return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet: data){
            sb.append(pet.getName() + " ").append(pet.getOwner());
        }
        return sb.toString();
    }

}
