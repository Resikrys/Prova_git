package dao;

import model.Room;

import java.util.List;

public interface RoomDAO {
    void save(Room room);                 // Añadir una nueva sala
    void delete(String name);            // Eliminar sala por nombre
    List<Room> findAll();                // Obtener todas las salas
}
