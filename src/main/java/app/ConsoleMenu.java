package app;

import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final EscapeRoomMenu escapeRoomMenu = new EscapeRoomMenu();

    public void start() {
        int option;
        do {
            System.out.println("\n=== Escape Room System ===");
            System.out.println("1. Manage Escape Rooms");
            System.out.println("2. Manage Rooms");
            System.out.println("3. Manage Clues");
            System.out.println("4. Manage Decorations");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> escapeRoomMenu.start();
                case 2 -> System.out.println("Go to 'Manage Escape Rooms' and select one to edit its rooms.");
                case 3 -> System.out.println("Go to 'Manage Escape Rooms' and select one to edit its clues.");
                case 4 -> System.out.println("Go to 'Manage Escape Rooms' and select one to edit decorations.");
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 5);
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // limpia el salto de línea
        return value;
    }
}
