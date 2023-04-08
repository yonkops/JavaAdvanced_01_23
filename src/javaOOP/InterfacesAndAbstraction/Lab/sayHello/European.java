package javaOOP.InterfacesAndAbstraction.Lab.sayHello;

public class European extends BasePerson {
    //private String name;

    European(String name){
        super(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
