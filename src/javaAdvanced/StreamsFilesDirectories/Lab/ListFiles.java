package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        String input = "src\\javaAdvanced\\StreamsFilesDirectories\\Files\\Files-and-Streams";

        File file = new File(input);
        File[] nestedFiles = file.listFiles();
        for (File nestedFile : nestedFiles) {
            if (nestedFile.isFile()){
                System.out.printf("%s: [%d]%n", nestedFile.getName(), nestedFile.length());
            }
        }

    }
}
