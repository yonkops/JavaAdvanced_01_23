package javaAdvanced.ExamPreparation.rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if (data.size() < this.capacity){
            data.add(rabbit);
        }
    }
    public void removeRabbit(String name){
        System.out.println(this.data.removeIf(r -> r.getName().equals(name)));
    }
    public void removeSpecies(String species){
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }
    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : this.data){
            if (rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbitsFromSpaces = new ArrayList<>();
        for (Rabbit rabbit : this.data){
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                rabbitsFromSpaces.add(rabbit);
            }
        }
        return rabbitsFromSpaces;
    }
    public int count(){
        return data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Rabbits available at: ").append(getName());
        for (Rabbit rabbit : this.data){
            if (rabbit.isAvailable()){
                sb.append(System.lineSeparator());
                sb.append(rabbit.toString());
            }
        }
        return sb.toString();
    }
}
