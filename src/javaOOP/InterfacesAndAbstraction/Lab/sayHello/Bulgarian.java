package javaOOP.InterfacesAndAbstraction.Lab.sayHello;

public class Bulgarian extends BasePerson{
    //private String name;

    Bulgarian(String name){
        super(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
