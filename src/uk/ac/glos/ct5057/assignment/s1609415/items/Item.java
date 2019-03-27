package uk.ac.glos.ct5057.assignment.s1609415.items;

public class Item {

    private String name;
    private String size;
    private double price;

    public Item(String name, String size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
