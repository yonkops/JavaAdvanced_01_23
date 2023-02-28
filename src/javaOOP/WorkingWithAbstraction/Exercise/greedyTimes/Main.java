
package javaOOP.WorkingWithAbstraction.Exercise.greedyTimes;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] inputItems = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> itemInBag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < inputItems.length; i += 2) {
            String name = inputItems[i];
            long amount = Long.parseLong(inputItems[i + 1]);
            String setType = getTypeOfItem(name);

            if (setType.equals("")) {
                continue;
            } else if (bagCapacity < itemInBag.values().stream()
                    .map(Map::values).flatMap(Collection::stream)
                    .mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (setType) {
                case "Gem":
                    if (!itemInBag.containsKey(setType)) {
                        if (itemInBag.containsKey("Gold")) {
                            if (amount > getGoldAmount(itemInBag)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemInBag.get(setType).values().stream()
                            .mapToLong(e -> e)
                            .sum() + amount > getGoldAmount(itemInBag)) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!itemInBag.containsKey(setType)) {
                        if (itemInBag.containsKey("Gem")) {
                            if (amount > getGoldAmount(itemInBag)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (itemInBag.get(setType).values().stream()
                            .mapToLong(e -> e).sum() + amount > itemInBag.get("Gem")
                            .values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!itemInBag.containsKey(setType)) {
                itemInBag.put((setType), new LinkedHashMap<String, Long>());
            }

            if (!itemInBag.get(setType).containsKey(name)) {
                itemInBag.get(setType).put(name, 0L);
            }


            itemInBag.get(setType).put(name, itemInBag.get(setType).get(name) + amount);
            if (setType.equals("Gold")) {
                gold += amount;
            } else if (setType.equals("Gem")) {
                gems += amount;
            } else if (setType.equals("Cash")) {
                cash += amount;
            }
        }

        printItemsInBag(itemInBag);
    }

    private static String getTypeOfItem(String name) {
        String setType = "";

        if (name.length() == 3) {
            setType = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            setType = "Gem";
        } else if (name.toLowerCase().equals("gold")) {
            setType = "Gold";
        }
        return setType;
    }

    private static void printItemsInBag(Map<String, LinkedHashMap<String, Long>> itemInBag) {
        for (var item : itemInBag.entrySet()) {
            Long sumValues = item.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", item.getKey(), sumValues));

            item.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey()
                            .compareTo(e1.getKey())).
                    forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static long getGoldAmount(Map<String, LinkedHashMap<String, Long>> itemInBag) {
        return itemInBag.get("Gold").values().stream().mapToLong(e -> e).sum();
    }
}