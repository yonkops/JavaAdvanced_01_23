package javaOOP.Encapsulation.Exercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> productList;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.productList = new ArrayList<>();
    }

    private void setName(String name) {
        Validations.validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validations.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product){
        if (product.getCost() > money){
            throw new IllegalStateException(this.getName() + " can't afford " + product.getName());
        }
        this.money = this.money - product.getCost();
        productList.add(product);
    }


    public String getName() {
        return name;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

}
