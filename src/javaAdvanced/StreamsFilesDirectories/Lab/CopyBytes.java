package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CopyBytes {
    public static void main(String[] args) {
        String input = "src/javaAdvanced/StreamsFilesDirectories/Files/input.txt";
        String output = "src/javaAdvanced/StreamsFilesDirectories/Files/03.CopyBytesOutput.txt";
        try (InputStream inputStream = new FileInputStream(input); OutputStream outputStream = new FileOutputStream(output)){
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                if (oneByte == 10 || oneByte == 32){
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
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
