package manager;

import dao.ScapeRoomDAO;
import dao.ScapeRoomDAOImpl;
import model.ScapeRoom;

import java.util.List;
import java.util.Scanner;

public class ScapeRoomManager {
    private final ScapeRoomDAO dao = new ScapeRoomDAOImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void createScapeRoom() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter difficulty: ");
        String difficulty = scanner.nextLine();
        System.out.print("Enter duration (in minutes): ");
        int duration = Integer.parseInt(scanner.nextLine());

        dao.create(new ScapeRoom(name, difficulty, duration));
        System.out.println("✅ Created!");
    }

    public void listScapeRooms() {
        List<ScapeRoom> rooms = dao.getAll();
        for (ScapeRoom room : rooms) {
            System.out.printf("ID: %d | %s | %s | %d min\n", room.getId(), room.getName(), room.getDifficulty(), room.getDuration());
        }
    }

    public void updateScapeRoom() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New difficulty: ");
        String difficulty = scanner.nextLine();
        System.out.print("New duration: ");
        int duration = Integer.parseInt(scanner.nextLine());

        ScapeRoom room = new ScapeRoom(name, difficulty, duration);
        room.setId(id);
        dao.update(room);
        System.out.println("🔁 Updated.");
    }

    public void deleteScapeRoom() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        dao.delete(id);
        System.out.println("🗑️ Deleted.");
    }
}