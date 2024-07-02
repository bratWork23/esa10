package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "src/main/resources/comments.txt"; // Pfad zur Textdatei

        while (true) {
            System.out.print("Kommentar eingeben (oder 'exit' zum Beenden): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                Comment comment = new Comment(input);
                comment.saveToFile(filename);
                System.out.println("Kommentar gespeichert.");
            } catch (IOException e) {
                System.err.println("Fehler beim Speichern des Kommentars: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
