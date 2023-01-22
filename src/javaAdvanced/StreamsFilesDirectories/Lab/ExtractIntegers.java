package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    static String input = "src/javaAdvanced/StreamsFilesDirectories/Files/input.txt";
    static String output = "src/javaAdvanced/StreamsFilesDirectories/Files/04.ExtractIntegersOutput.txt";
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream(input));
             PrintWriter out = new PrintWriter(new FileOutputStream(output))) {
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
