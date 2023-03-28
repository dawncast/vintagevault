package model;

import org.json.JSONObject;
import persistence.Writable;

// represents a single clothing item with name, size, price, and category
public class Clothes implements Writable {
    private String name;                    // clothing name
    private int size;                       // clothing size
    private int price;                     // clothing colour
    private String category;               // clothing category

    // EFFECTS: constructs a clothing item with name, size, price, and category
    public Clothes(String name, int size, int price, String category) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    //EFFECTS: get name of clothing item
    public String getName() {
        return name;
    }

    //EFFECTS: get size of clothing item
    public int getSize() {
        return size;
    }

    //EFFECTS: get price of clothing item
    public int getPrice() {
        return price;
    }

    //EFFECTS: get category of clothing item
    public String getCategory() {
        return category;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("size", size);
        json.put("price", price);
        json.put("category", category);
        return json;
    }
}
