package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CommentTest {
    private Path tempFilePath;

    @BeforeEach
    public void setup() throws IOException {
        tempFilePath = Files.createTempFile("test_comments", ".txt");
    }

    @AfterEach
    public void cleanup() throws IOException {
        Files.deleteIfExists(tempFilePath);
    }

    @Test
    public void testValidComment() throws IOException {
        String commentText = "Dies ist ein gültiger Kommentar.";
        Comment comment = new Comment(commentText);
        comment.saveToFile(tempFilePath.toString());

        String fileContent = Files.readString(tempFilePath);
        assertTrue(fileContent.contains("Benutzer: " + commentText));
    }
    @Test
    public void testTooLongComment() {
        String commentText = "x".repeat(501);
        assertThrows(IllegalArgumentException.class, () -> new Comment(commentText));
    }

    @Test
    public void testEmptyComment() throws IOException {
        String commentText = "";
        Comment comment = new Comment(commentText);
        comment.saveToFile(tempFilePath.toString());

        String fileContent = Files.readString(tempFilePath);
        assertTrue(fileContent.contains("Benutzer: ")); // Leerzeichen nach "Benutzer:"
    }
}
