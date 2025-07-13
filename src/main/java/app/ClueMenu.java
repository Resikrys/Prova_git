package app;

import model.Clue;
import model.EscapeRoom;

import java.util.Scanner;

public class ClueMenu {
    private final EscapeRoom escapeRoom;
    private final Scanner scanner = new Scanner(System.in);

    public ClueMenu(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public void start() {
        int option;
        do {
            System.out.println("\n--- Clue Management (" + escapeRoom.getName() + ") ---");
            System.out.println("1. Add Clue");
            System.out.println("2. Remove Clue");
            System.out.println("3. List Clues");
            System.out.println("4. Back");

            option = readInt("Choose an option: ");

            switch (option) {
                case 1 -> addClue();
                case 2 -> removeClue();
                case 3 -> escapeRoom.listClues();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 4);
    }

    private void addClue() {
        System.out.print("Enter description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter theme: ");
        String theme = scanner.nextLine();
        double price = readDouble("Enter price (€): ");

        escapeRoom.addClue(new Clue(desc, theme, price));
        System.out.println("Clue added.");
    }

    private void removeClue() {
        System.out.print("Enter description of clue to remove: ");
        String desc = scanner.nextLine();
        escapeRoom.removeClue(desc);
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(prompt);
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print(prompt);
        }
        double val = scanner.nextDouble();
        scanner.nextLine();
        return val;
    }
}
