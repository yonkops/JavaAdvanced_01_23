package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }
    public boolean addChild(Child child){
        if (this.capacity > registry.size()){
            this.registry.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChild(String firstName){
        return this.registry.removeIf(child -> child.getFirstName().equals(firstName));
    }
    public int getChildrenCount(){
        return this.registry.size();
    }
    public Child getChild(String firstName){
        for (Child child : this.registry){
            if (child.getFirstName().equals(firstName)){
                return child;
            }
        }
        return null;
    }
    public String registryReport(){
        StringBuilder sb = new StringBuilder();
        //sortGarden();
        //registry = new ArrayList<>(sortGardenNew());
        sortGarden();
        sb.append(String.format("Registered children in %s:", this.name));
        int counter = this.registry.size();
        for (Child child : this.registry){
            sb.append(System.lineSeparator());
            sb.append(child.toString());
            if (counter > 1){
                sb.append(System.lineSeparator());
                sb.append("--");
            }
            counter --;
        }
        return sb.toString().trim();
    }
    private void sortGarden(){
        this.registry.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));
    }
    private List<Child> sortGardenNew(){
        List<Child> sorted = registry.stream().sorted((r, l) ->{
            if (r.getAge() == l.getAge()){
                if (r.getFirstName().equals(l.getFirstName())){
                    return r.getLastName().compareTo(l.getLastName());
                } else {
                    return r.getFirstName().compareTo(l.getFirstName());
                }
            } else {
                return r.getAge() - l.getAge();
            }
        }).collect(Collectors.toList());
        return sorted;
        /*this.registry.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));*/
    }

}
