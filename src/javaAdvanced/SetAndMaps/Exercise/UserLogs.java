package javaAdvanced.SetAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Map<String, Integer>> userData = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String ip = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String user = input.split("\\s+")[2].split("=")[1];
            userData.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> currentIp = userData.get(user);

            if (!currentIp.containsKey(ip)){
                currentIp.put(ip, 1);
            } else {
                currentIp.put(ip, currentIp.get(ip) + 1);
            }
            input = scanner.nextLine();
        }
        for (String userName : userData.keySet()) {
            System.out.println(userName + ": ");
            Map<String, Integer> currentIp = userData.get(userName);
            int count = currentIp.size();
            for (String ip : currentIp.keySet()) {
                if (count <= 1){
                    System.out.println(ip + " => " + currentIp.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + currentIp.get(ip) + ", ");
                }
                count--;
            }
        }
    }
}
