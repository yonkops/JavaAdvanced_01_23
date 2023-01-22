package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "src\\javaAdvanced\\StreamsFilesDirectories\\Files\\Files-and-Streams";
        File root = new File(path);
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;
        while (!dirs.isEmpty()){
            File currentDir = dirs.poll();
            File[] nestedFiles = currentDir.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()){
                    dirs.offer(nestedFile);
                }
            }
            count++;
            System.out.println(currentDir.getName());
        }
        System.out.println(count + " folders");
    }
}
