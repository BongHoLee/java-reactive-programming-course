package com.bong.courseutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileReader {
    private static final String BASE_PATH = "assignment/sec01/";

    private final String targetFile;

    public FileReader(String targetFile) {
        this.targetFile = BASE_PATH + targetFile;
        checkValidFile();
    }

    private void checkValidFile() {
        if (FileReader.class.getClassLoader().getResource(targetFile) == null) {
            throw new IllegalArgumentException("not exists file: " + this.targetFile);
        }
    }

    public void  passDataStreamTo(Consumer<Stream<String>> consumer) {
        try (InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(targetFile)) {
            try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                Stream<String> lines = bufferedReader.lines();
                consumer.accept(lines);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
