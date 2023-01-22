package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadFile {
    public static void main(String[] args) {
        String path ="src/javaAdvanced/StreamsFilesDirectories/Files/input.txt";

        try (InputStream inputStream = new FileInputStream(path)){
            int oneByte = inputStream.read();
            while (oneByte >= 0){
                System.out.printf("%s ",
                        Integer.toBinaryString(oneByte));
                oneByte = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
