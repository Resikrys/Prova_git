package menu;

import manager.ScapeRoomManager;

import java.util.Scanner;

public class ScapeRoomMenu {
    private final ScapeRoomManager manager = new ScapeRoomManager();
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        int option;
        do {
            System.out.println("\n--- ScapeRoom Menu ---");
            System.out.println("1. Create ScapeRoom");
            System.out.println("2. List ScapeRooms");
            System.out.println("3. Update ScapeRoom");
            System.out.println("4. Delete ScapeRoom");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> manager.createScapeRoom();
                case 2 -> manager.listScapeRooms();
                case 3 -> manager.updateScapeRoom();
                case 4 -> manager.deleteScapeRoom();
                case 0 -> System.out.println("👋 Bye!");
                default -> System.out.println("❌ Invalid option.");
            }
        } while (option != 0);
    }
}