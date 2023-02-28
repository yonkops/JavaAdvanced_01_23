package javaAdvanced.IteratorsComparators.Exercise.Collection;


import java.util.Iterator;
import java.util.List;
public class ListyIterator<T> implements Iterable<String>{
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
    public void printAll() {
        for (T element : elements){
            System.out.print(element + " ");
        }
        System.out.println();
    }
    @Override
    public Iterator<String> iterator() {
        return new collectionIterator();
    }

    private class collectionIterator implements Iterator<String>{
        private int currentIndex = 0;


        @Override
        public boolean hasNext() {
            return currentIndex < elements.size() - 1;
        }

        @Override
        public String next() {
            T element = elements.get(currentIndex);
            currentIndex ++;
            return element.toString();
        }
    }
}
