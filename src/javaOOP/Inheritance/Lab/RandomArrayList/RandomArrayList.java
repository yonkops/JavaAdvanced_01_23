package javaOOP.Inheritance.Lab.RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {
    private final Random random;
    public RandomArrayList() {
        super();
        this.random = new Random();
    }
    public Object getRandomElement() {
        int index = this.random.nextInt(super.size()); //-min.Int -> max.Int
        Object element = super.get(index);
        super.remove(index);
        return element;
    }
}
