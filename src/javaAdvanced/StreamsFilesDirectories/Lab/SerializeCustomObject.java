package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String path = "src/javaAdvanced/StreamsFilesDirectories/Files/save.txt";
        Cube cube = new Cube();
        cube.colour = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(cube);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    static class Cube implements Serializable {
        String colour;
        double width;
        double height;
        double depth;
    }
}
