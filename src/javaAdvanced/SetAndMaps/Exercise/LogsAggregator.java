package javaAdvanced.SetAndMaps.Exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, Set<String>>> logsData = new TreeMap<>();
        int numInputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numInputs; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);

            if (logsData.containsKey(name)){
                Map<Integer, Set<String>> userData = logsData.get(name);
                int total = Integer.parseInt(userData.keySet().toString());
                duration += total;
                userData.put(duration, new TreeSet<>());
                userData.get(duration).add(ip);
            } else {
                logsData.putIfAbsent(name, new TreeMap<>());
                Map<Integer, Set<String>> userData = logsData.get(name);
                userData.put(duration, new TreeSet<>());
                userData.get(duration).add(ip);
            }
        }
        System.out.println();

    }
}
