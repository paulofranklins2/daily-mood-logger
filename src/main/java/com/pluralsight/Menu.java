package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public int showMainMenu() {
        clearConsole();
        System.out.println("[1] Log a new mood");
        System.out.println("[2] View past moods");
        System.out.println("[3] Exit");
        return getIntInput("Enter choice: ");
    }

    public void showMoodMenu(List<String> moodList) {
        clearConsole();
        for (int i = 0; i < moodList.size(); i++) {
            System.out.println("[" + i + "] " + moodList.get(i));
        }

        int choice = getIntInput("Enter choice: ");
        if (choice > 0 && choice < moodList.size()) {
            new MoodService().logMood(moodList.get(choice));
        } else if (choice == 0) {
            System.out.println("Returning to main menu.");
        } else {
            System.out.println("Invalid option.");
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void clearConsole() {
        for (int i = 0; i < 50; i++) System.out.println();
    }
}
