package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WriteFile {
    public static void main(String[] args) {

        String input = "src/javaAdvanced/StreamsFilesDirectories/Files/input.txt";
        String output = "src/javaAdvanced/StreamsFilesDirectories/Files/02.WriteToFileOutput.txt";
        try (InputStream inputStream = new FileInputStream(input); OutputStream outputStream = new FileOutputStream(output)){
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                ArrayList<Character> punctuation = new ArrayList<>();
                Collections.addAll( punctuation,',','.','!','?');
                if (!punctuation.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
                oneByte = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
