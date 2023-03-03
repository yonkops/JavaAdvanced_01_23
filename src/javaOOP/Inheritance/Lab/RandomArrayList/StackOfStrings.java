package javaOOP.Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    public StackOfStrings() {
        this.data = new ArrayList<>();
    }
    private int lastIndex(){
        return this.data.size() - 1;
    }
    public void push(String string) {
        this.data.add(string);
        //TO DO
    }
    public String pop() {
        if (isEmpty()){
            throw new IllegalStateException();
        }
        String element = this.data.get(lastIndex());
        this.data.remove(element);
        return element;
    }
    public String peek() {
        if (isEmpty()){
            throw new IllegalStateException();
        }
        String element = this.data.get(lastIndex());
        //TO DO
        return element;
    }
    public boolean isEmpty() {
        return this.lastIndex() == 0;
    }
}
