package javaAdvanced.SetAndMaps.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, Map<String, Double>> stores = new TreeMap<>();
        while (!input.equals("Revision")){
            String[] command = input.split(", ");
            String store = command[0];
            String product = command[1];
            double price = Double.parseDouble(command[2]);
            if (!stores.containsKey(store)){
                Map<String, Double> current = new LinkedHashMap<>();
                current.put(product, price);
                stores.put(store,current);
            } else {
                stores.get(store).put(product,price);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : stores.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> product : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f %n", product.getKey(), product.getValue());
            }
        }
    }

}
