package model;

import java.util.ArrayList;
import java.util.List;

public class EscapeRoom {
    private String name;
    private List<Room> rooms = new ArrayList<>();
    private List<Clue> clues = new ArrayList<>();
    private List<DecorItem> decorItems = new ArrayList<>();

    public EscapeRoom(String name) {
        this.name = name;
    }

    // --- General ---

    public String getName() {
        return name;
    }

    // --- Rooms ---

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(String name) {
        rooms.removeIf(r -> r.getName().equalsIgnoreCase(name));
    }

    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms.");
        } else {
            rooms.forEach(System.out::println);
        }
    }

    // --- Clues ---

    public void addClue(Clue clue) {
        clues.add(clue);
    }

    public void removeClue(String description) {
        clues.removeIf(c -> c.getDescription().equalsIgnoreCase(description));
    }

    public void listClues() {
        if (clues.isEmpty()) {
            System.out.println("No clues.");
        } else {
            clues.forEach(System.out::println);
        }
    }

    // --- Decor Items ---

    public void addDecorItem(DecorItem item) {
        decorItems.add(item);
    }

    public void removeDecorItem(String name) {
        decorItems.removeIf(d -> d.getName().equalsIgnoreCase(name));
    }

    public void listDecorItems() {
        if (decorItems.isEmpty()) {
            System.out.println("No decoration items.");
        } else {
            decorItems.forEach(System.out::println);
        }
    }

    // --- Inventory Summary ---

    public void showInventory() {
        System.out.println("\nRooms:");
        listRooms();
        System.out.println("\nClues:");
        listClues();
        System.out.println("\nDecoration Items:");
        listDecorItems();
        System.out.println("\nTotal Inventory Value: €" + getTotalInventoryValue());
    }

    public double getTotalInventoryValue() {
        double total = 0;
        for (Room r : rooms) total += r.getPrice();
        for (Clue c : clues) total += c.getPrice();
        for (DecorItem d : decorItems) total += d.getPrice();
        return total;
    }
}
