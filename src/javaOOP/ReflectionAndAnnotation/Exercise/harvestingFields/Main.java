package javaOOP.ReflectionAndAnnotation.Exercise.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Scanner scanner = new Scanner(System.in);
		Field[] fields = clazz.getDeclaredFields();
		Consumer<Field> printer = field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {
			Field[] modifiedFields = fields;
			if (!command.equals("all")) {
				modifiedFields = getModifiedFields(fields, command);
			}
			for (Field field : modifiedFields){
				printer.accept(field);
			}
			command = scanner.nextLine();
		}

	}

	private static Field[] getModifiedFields(Field[] fields, String command) {
		return Arrays.stream(fields).filter(f -> Modifier.toString((f.getModifiers())).startsWith(command)).toArray(Field[]::new);
	}
}
