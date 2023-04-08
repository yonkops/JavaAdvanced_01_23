package javaOOP.ReflectionAndAnnotation.Lab.gettersSetters;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> aClass = Reflection.class;
        Method[] methods = aClass.getDeclaredMethods();
        Method[] getters = Arrays.stream(methods).filter(
                m -> m.getName().startsWith("get") &&
                        m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s will return class %s%n",
                        m.getName(), m.getReturnType().getName()));
        Method[] setters = Arrays.stream(methods).filter(
                        m -> m.getName().startsWith("set")/* &&
                                m.getParameterCount() == 1*/)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);
        Arrays.stream(setters).forEach(m ->
                System.out.printf("%s and will set field of class %s%n",
                        m.getName(), m.getParameterTypes()[0].getName()));
    }
}
