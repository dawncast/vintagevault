package model;

// represents a single clothing item with name, size, price, and category
public class Clothes {
    private String name;       // clothing name
    private int size;          // clothing size
    private int price;     // clothing colour
    private String category;   // clothing category


    public Clothes(String name, int size, int price, String category) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
