package uk.ac.glos.ct5057.assignment.s1609415.items;


/**
 * This class stores the information about an Item
 *
 * @author  Joshua Walker
 * @version 1.0
 */
public class Item {

    private String name;
    private double size;
    private double price;
    private Location warehouse;

    public enum Location {
        East,
        West
    }

    public Item(String name, double size, double price, Location warehouse) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public Location getWarehouse() {
        return warehouse;
    }
}
