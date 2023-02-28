package javaAdvanced.ExamPreparation.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Present> getData() {
        return data;
    }
    public int count(){
        return data.size();
    }
    public void add(Present present){
        if(this.data.size() < this.capacity){
            this.data.add(present);
        } else {
            throw new IllegalStateException("No more space");
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(present -> present.getName().equals(name));
    }
    public Present heaviestPresent(){
        return data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }
    public Present getPresent(String name){
        return data.stream().filter(present -> present.getName().equals(name)).findAny().orElse(null);
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getColor())
                .append(" bag contains:");
        for (Present present : this.data){
            sb.append(System.lineSeparator());
            sb.append(present.toString());
        }
        return sb.toString();
    }
}
