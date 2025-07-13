package app;

import model.EscapeRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscapeRoomMenu {
    private final List<EscapeRoom> escapeRooms = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            System.out.println("\n--- Escape Room Management ---");
            System.out.println("1. Create Escape Room");
            System.out.println("2. List Escape Rooms");
            System.out.println("3. Delete Escape Room");
            System.out.println("4. Select Escape Room");
            System.out.println("5. Back to Main Menu");

            System.out.print("Choose an option: ");
            option = readInt();

            switch (option) {
                case 1 -> createEscapeRoom();
                case 2 -> listEscapeRooms();
                case 3 -> deleteEscapeRoom();
                case 4 -> {
                    EscapeRoom selected = selectEscapeRoom();
                    if (selected != null) {
                        new RoomMenu().start();
                    }
                }
                case 5 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 5);
    }

    private void createEscapeRoom() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        escapeRooms.add(new EscapeRoom(name));
        System.out.println("Escape Room created.");
    }

    private void listEscapeRooms() {
        if (escapeRooms.isEmpty()) {
            System.out.println("No Escape Rooms.");
        } else {
            System.out.println("Escape Rooms:");
            for (int i = 0; i < escapeRooms.size(); i++) {
                System.out.println((i + 1) + ". " + escapeRooms.get(i).getName());
            }
        }
    }

    private void deleteEscapeRoom() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        boolean removed = escapeRooms.removeIf(er -> er.getName().equalsIgnoreCase(name));
        System.out.println(removed ? "Deleted." : "Not found.");
    }

    private EscapeRoom selectEscapeRoom() {
        if (escapeRooms.isEmpty()) {
            System.out.println("No Escape Rooms to select.");
            return null;
        }
        listEscapeRooms();
        int index = readInt("Select Escape Room number: ") - 1;
        if (index >= 0 && index < escapeRooms.size()) {
            return escapeRooms.get(index);
        } else {
            System.out.println("Invalid selection.");
            return null;
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }
}
