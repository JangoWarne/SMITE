package uk.ac.glos.ct5057.assignment.s1609415.items;

public class Item {

    private String name;
    private String size;
    private double price;
    private Location warehouse;
    private boolean inBasket;

    public enum Location {
        East,
        West
    }

    public Item(String name, String size, double price, Location warehouse) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.warehouse = warehouse;
        inBasket = false;
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

    public Location getWarehouse() {
        return warehouse;
    }

    public boolean isInBasket() {
        return inBasket;
    }

    public void setInBasket(boolean inBasket) {
        this.inBasket = inBasket;
    }
}
