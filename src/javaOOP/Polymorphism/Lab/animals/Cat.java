package javaOOP.Polymorphism.Lab.animals;

public class Cat extends Animal {
    public Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    String explainSelf() {
        return String.format("%s%nMEEOW",
                super.toString());
    }

}
