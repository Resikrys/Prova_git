package dao;

import model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private final List<Room> roomList = new ArrayList<>();

    @Override
    public void save(Room room) {
        roomList.add(room);
    }

    @Override
    public void delete(String name) {
        roomList.removeIf(r -> r.getName().equalsIgnoreCase(name));
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(roomList); // se devuelve una copia para proteger la lista original
    }
}
