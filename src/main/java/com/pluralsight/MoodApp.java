package com.pluralsight;

public class MoodApp {
    private final MoodService moodService = new MoodService();
    private final Menu menu = new Menu();

    public void start() {
        while (true) {
            int option = menu.showMainMenu();
            switch (option) {
                case 1 -> menu.showMoodMenu(moodService.getMoodList());
                case 2 -> moodService.displayAllMoods();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
