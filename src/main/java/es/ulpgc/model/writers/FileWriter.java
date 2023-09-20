package es.ulpgc.model.writers;

import es.ulpgc.model.Writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

public class FileWriter implements Writer {

    @Override
    public void write(String path, String object) {
        try {
            if (!Files.exists(Path.of(path))) Files.createFile(Path.of(path));
            Files.write(Path.of(path), object.getBytes(), APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
