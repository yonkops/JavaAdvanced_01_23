package javaOOP.InterfacesAndAbstraction.Lab.sayHello;

public class Chinese extends BasePerson {

    Chinese(String name){
        super(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
