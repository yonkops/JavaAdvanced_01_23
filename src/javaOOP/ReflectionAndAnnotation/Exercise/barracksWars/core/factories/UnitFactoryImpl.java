package javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.core.factories;

import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.Unit;
import javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"javaOOP.ReflectionAndAnnotation.Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalArgumentException |
				 InvocationTargetException | IllegalAccessException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
}
