package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static int userIntInput(String s, Scanner scanner) {
        while (true) try {
            System.out.print(s);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter a valid option!");
            scanner.nextLine();
        }
    }

    public static void mainMenuOption(int option) {
        switch (option) {
            case 1:
                moodOptionScreen();
                break;
            case 2:
                retrieveAllDailyMoods();
                break;
            case 3:
                break;
            default:
                mainScreen();
        }
    }

    public static void moodMenuOption(int option) {
        switch (option) {
            case 0:
                break;
            case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10:
                writeDailyMood(getMoodList().get(option));
                break;
            default:
                moodOptionScreen();
                break;
        }
    }

    public static void moodOptionScreen() {
        clearConsole();
        var moodOptions = getMoodList();
        for (int i = 0; i < moodOptions.size(); i++) {
            System.out.println("[" + i + "] " + moodOptions.get(i));
        }
        int moodOption = userIntInput("Enter choice: ", scanner);
        moodMenuOption(moodOption);
    }

    private static ArrayList<String> getMoodList() {
        return new ArrayList<>(Arrays.asList("Exit", "Happy", "Sad", "Angry", "Anxious", "Excited", "Tired", "Stressed", "Grateful", "Lonely", "Calm"));
    }

    public static void writeDailyMood(String mood) {
        var localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var fileName = "DailyMood.txt";
        var dirPath = "src/main/resources/";

        try {
            var fileWriter = new FileWriter(dirPath + fileName, true);
            fileWriter.write(LocalDate.now().format(localDateFormatter) + ": " + mood + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error writing mood to file", e);
        }
    }

    public static void retrieveAllDailyMoods() {
        String line = "";
        try {
            var bufferedReader = new BufferedReader(new FileReader("src/main/resources/DailyMood.txt"));
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mainScreen() {
        clearConsole();
        System.out.println("[1] Log a new mood");
        System.out.println("[2] View past moods");
        System.out.println("[3] Exit");
        var mainMenuOption = userIntInput("Enter choice: ", scanner);
        mainMenuOption(mainMenuOption);
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void main(String[] args) {
        mainScreen();
    }
}