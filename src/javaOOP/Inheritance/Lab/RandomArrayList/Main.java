package javaOOP.Inheritance.Lab.RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add("5");
        randomArrayList.add("6");
        randomArrayList.add("7");
        randomArrayList.add("8");
        randomArrayList.add("9");
        randomArrayList.add("10");
        randomArrayList.add("11");
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());

        StackOfStrings sos = new StackOfStrings();
        sos.push("one");
        sos.push("two");
        sos.push("three");
        System.out.println(sos.isEmpty());
        System.out.println(sos.peek());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
        System.out.println(sos.pop());
    }
}
