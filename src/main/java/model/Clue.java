package model;

public class Clue {
    private String description;
    private String theme;
    private double price;

    public Clue(String description, String theme, double price) {
        this.description = description;
        this.theme = theme;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getTheme() {
        return theme;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Clue: " + description + " | Theme: " + theme + " | Price: €" + price;
    }
}
