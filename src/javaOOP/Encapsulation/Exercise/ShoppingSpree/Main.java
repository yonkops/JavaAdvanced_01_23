package javaOOP.Encapsulation.Exercise.ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people;
        List<Product> productList;
        try {
            people = parsePeoples(scanner);
            productList = parseProducts(scanner);
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }
        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("END")) {
            String name = input[0];
            String product = input[1];
            Person searchedPerson = people
                    .stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst().get();
            Product searchedProduct = productList
                    .stream()
                    .filter(p -> p.getName().equals(product))
                    .findFirst().get();
            try {
                searchedPerson.buyProduct(searchedProduct);
                System.out.println(searchedPerson.getName() + " bought " + searchedProduct.getName());
            } catch (IllegalStateException illegalStateException) {
                System.out.println(illegalStateException.getMessage());
            }
            input = scanner.nextLine().split("\\s+");
        }
        for (Person person : people) {
            List<Product> personProducts = person.getProductList();
            System.out.print(person.getName() + " - ");
            if (personProducts.isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                List<String> productsName = personProducts
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
                System.out.println(String.join(",", productsName));
            }
        }
    }

    private static List<Product> parseProducts(Scanner scanner) {
        String[] input = scanner.nextLine().split(";");
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String name = input[i].split("=")[0];
            double price = Double.parseDouble(input[i].split("=")[1]);
            productList.add(new Product(name, price));
        }
        return productList;
    }

    private static List<Person> parsePeoples(Scanner scanner) {
        String[] input = scanner.nextLine().split(";");
        List<Person> shoppingPersons = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String name = input[i].split("=")[0];
            double money = Double.parseDouble(input[i].split("=")[1]);
            shoppingPersons.add(new Person(name, money));
        }
        return shoppingPersons;
    }

}
