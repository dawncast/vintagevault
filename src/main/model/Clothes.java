package model;

public class Clothes {
    private String name;       // clothing name
    private static int nextAccountId = 1;  // tracks id of next account created
    private int size;          // clothing size
    private int price;     // clothing colour
    private String category;   // clothing category
    private int date;          // input date of clothing in DD/MM/YY


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
