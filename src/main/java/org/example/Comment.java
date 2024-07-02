package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Comment {
    private String text;

    public Comment(String text) {
        validateCommentLength(text);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void saveToFile(String filename) throws IOException {
        Files.write(Paths.get(filename), ("Benutzer: " + text + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    private void validateCommentLength(String text) {
        if (text.trim().length() > 500) {
            throw new IllegalArgumentException("Kommentar zu lang (max. 500 Zeichen)");
        }
    }
}
