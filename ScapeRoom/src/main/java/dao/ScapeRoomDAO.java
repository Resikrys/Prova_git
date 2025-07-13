package dao;

import model.ScapeRoom;

import java.util.List;

public interface ScapeRoomDAO {

    void create(ScapeRoom room);
    List<ScapeRoom> getAll();
    void update(ScapeRoom room);
    void delete(int id);
}
