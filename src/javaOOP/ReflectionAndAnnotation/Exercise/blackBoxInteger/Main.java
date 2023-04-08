package javaOOP.ReflectionAndAnnotation.Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Field hiddenValue = clazz.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("_");
        while (!input[0].equals("END")) {
            String methodName = input[0];
            int value = Integer.parseInt(input[1]);
            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(hiddenValue.get(blackBoxInt));
            input = scanner.nextLine().split("_");
        }
    }
}
