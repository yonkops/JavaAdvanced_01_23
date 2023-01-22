package javaAdvanced.StreamsFilesDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {

    public static void main(String[] args) {
        Path inPath = Paths.get("src/javaAdvanced/StreamsFilesDirectories/Files/input.txt");
        Path outPath = Paths.get("src/javaAdvanced/StreamsFilesDirectories/Files/06.SortLinesOutput.txt");

        try {
            List<String> sortedLines = Files.readAllLines(inPath)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            Files.write(outPath, sortedLines);

            /*List<String> lines = Files.readAllLines(inPath);
            lines = lines.stream().filter(l ->
                    !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outPath, lines);*/
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
