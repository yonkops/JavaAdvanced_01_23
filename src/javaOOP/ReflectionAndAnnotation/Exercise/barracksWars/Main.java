package javaOOP.ReflectionAndAnnotation.Exercise.barracksWars;

import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Repository;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Runnable;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.Engine;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.factories.UnitFactoryImpl;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
