package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<Clothes> clothesList;

    //EFFECTS: constructs an empty catalogue of clothes
    public Catalogue() {
        this.clothesList = new ArrayList<>();
    }

    //MODIFIES: this
    //EFFECTS: adds a new clothing item to existing catalogue of clothing
    public void addClothes(String itemName, int itemSize, int itemPrice, String itemCategory) {
        this.clothesList.add(new Clothes(itemName, itemSize, itemPrice, itemCategory));
    }

    public List<Clothes> getList() {
        return this.clothesList;
    }

}
