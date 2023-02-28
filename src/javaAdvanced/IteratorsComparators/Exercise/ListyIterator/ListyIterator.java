package javaAdvanced.IteratorsComparators.Exercise.ListyIterator;


import java.util.Arrays;
import java.util.List;



public class ListyIterator<T> {
    private List<T> elements;
    private int currentIndex;

    public ListyIterator(T... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }
    public boolean move(){
        if (hasNext()){
            this.currentIndex++;
            return true;
        }
        return false;
    }
    public boolean hasNext(){
        if (currentIndex < elements.size() - 1){
            return true;
        }
        return false;
    }
    public void print() {
        if (elements.size() == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            System.out.println(this.elements.get(currentIndex));
        }
    }
}
