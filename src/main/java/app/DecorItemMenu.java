package app;

import model.DecorItem;
import model.EscapeRoom;

import java.util.Scanner;

public class DecorItemMenu {
    private final EscapeRoom escapeRoom;
    private final Scanner scanner = new Scanner(System.in);

    public DecorItemMenu(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public void start() {
        int option;
        do {
            System.out.println("\n--- Decoration Management (" + escapeRoom.getName() + ") ---");
            System.out.println("1. Add Decor Item");
            System.out.println("2. Remove Decor Item");
            System.out.println("3. List Decor Items");
            System.out.println("4. Back");

            option = readInt("Choose an option: ");

            switch (option) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> escapeRoom.listDecorItems();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 4);
    }

    private void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter material: ");
        String material = scanner.nextLine();
        double price = readDouble("Enter price (€): ");

        escapeRoom.addDecorItem(new DecorItem(name, material, price));
        System.out.println("Item added.");
    }

    private void removeItem() {
        System.out.print("Enter item name to remove: ");
        String name = scanner.nextLine();
        escapeRoom.removeDecorItem(name);
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
