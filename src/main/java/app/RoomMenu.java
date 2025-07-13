package app;

import model.Room;
import service.RoomService;

import java.util.Scanner;
import java.util.List;

public class RoomMenu {

    private final RoomService roomService = new RoomService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            System.out.println("\n--- Room Management ---");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. List Rooms");
            System.out.println("4. Back");

            option = readInt("Choose an option: ");

            switch (option) {
                case 1 -> addRoom();
                case 2 -> removeRoom();
                case 3 -> listRooms();
                case 4 -> System.out.println("Returning...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 4);
    }

    private void addRoom() {
        System.out.print("Enter room name: ");
        String name = scanner.nextLine();
        int difficulty = readInt("Enter difficulty (1-5): ");
        double price = readDouble("Enter price (€): ");

        Room room = new Room(name, difficulty, price);
        roomService.addRoom(room);
        System.out.println("Room added.");
    }

    private void removeRoom() {
        System.out.print("Enter room name to remove: ");
        String name = scanner.nextLine();
        roomService.deleteRoom(name);
        System.out.println("Room removed (if it existed).");
    }

    private void listRooms() {
        List<Room> rooms = roomService.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            rooms.forEach(System.out::println);
        }
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print(prompt);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print(prompt);
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
