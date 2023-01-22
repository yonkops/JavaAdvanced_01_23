package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.*;

public class WriteEveryThirdLine {
    static String input = "src/javaAdvanced/StreamsFilesDirectories/Files/input.txt";
    static String output = "src/javaAdvanced/StreamsFilesDirectories/Files/05.WriteEveryThirdLineOutput.txt";
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(input));
        PrintWriter out = new PrintWriter(new FileWriter(output))) {
            int count = 1;
            String line = in.readLine();
            while (line != null){
                if (count % 3 == 0){
                    out.println(line);
                }
                count++;
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
