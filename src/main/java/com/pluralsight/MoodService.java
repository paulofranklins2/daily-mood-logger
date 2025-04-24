package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MoodService {
    private static final String FILE_PATH = "src/main/resources/DailyMood.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<String> getMoodList() {
        return List.of("Exit", "Happy", "Sad", "Angry", "Anxious", "Excited", "Tired", "Stressed", "Grateful", "Lonely", "Calm");
    }

    public void logMood(String mood) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(LocalDate.now().format(formatter) + ": " + mood + "\n");
        } catch (IOException e) {
            System.err.println("Error saving mood: " + e.getMessage());
        }
    }

    public void displayAllMoods() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading moods: " + e.getMessage());
        }
    }
}
