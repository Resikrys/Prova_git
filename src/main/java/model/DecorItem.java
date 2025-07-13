package model;

public class DecorItem {
    private String name;
    private String material;
    private double price;

    public DecorItem(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "DecorItem: " + name + " | Material: " + material + " | Price: €" + price;
    }
}
