package dao;

import model.ScapeRoom;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScapeRoomDAOImpl implements ScapeRoomDAO {
    @Override
    public void create(ScapeRoom room) {
        String sql = "INSERT INTO scape_rooms (name, difficulty, duration) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getName());
            stmt.setString(2, room.getDifficulty());
            stmt.setInt(3, room.getDuration());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ScapeRoom> getAll() {
        List<ScapeRoom> rooms = new ArrayList<>();
        String sql = "SELECT * FROM scape_rooms";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ScapeRoom room = new ScapeRoom();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setDifficulty(rs.getString("difficulty"));
                room.setDuration(rs.getInt("duration"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public void update(ScapeRoom room) {
        String sql = "UPDATE scape_rooms SET name=?, difficulty=?, duration=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, room.getName());
            stmt.setString(2, room.getDifficulty());
            stmt.setInt(3, room.getDuration());
            stmt.setInt(4, room.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM scape_rooms WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
