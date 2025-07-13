package service;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import model.Room;

import java.util.List;

public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService() {
        this.roomDAO = new RoomDAOImpl(); // se usa implementación en memoria
    }

    public void addRoom(Room room) {
        roomDAO.save(room);
    }

    public void deleteRoom(String name) {
        roomDAO.delete(name);
    }

    public List<Room> getAllRooms() {
        return roomDAO.findAll();
    }
}
