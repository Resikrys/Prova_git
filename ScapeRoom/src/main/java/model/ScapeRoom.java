package model;

public class ScapeRoom {

    private int id;
    private String name;
    private String difficulty;
    private int duration;

    public ScapeRoom() {}

    public ScapeRoom(String name, String difficulty, int duration) {
        this.name = name;
        this.difficulty = difficulty;
        this.duration = duration;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
}