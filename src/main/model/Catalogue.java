package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//represents a catalogue that contains a list of clothes
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

    //MODIFIES: this
    //EFFECTS: removes a clothing item from catalogue by clothing item name
    public void removeClothes(String name) {
        Clothes itemToRemove = null;
        for (Clothes clothesItem : clothesList) {
            if (name.equals(clothesItem.getName())) {
                itemToRemove = clothesItem;
            }
        }
        this.clothesList.remove(itemToRemove);
    }

    // REQUIRES: there is at least one item in catalogue
    // MODIFIES: this
    // EFFECTS: sort clothing item in catalogue from lowest to highest price
    public void sortPrice() {
        Collections.sort(clothesList, (clothesA, clothesB) -> {
            if (clothesA.getPrice() > clothesB.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        });
    }

    // REQUIRES: there is at least one item in catalogue
    // MODIFIES: this
    // EFFECTS: sort clothing item in catalogue from smallest to largest size
    public void sortSize() {
        Collections.sort(clothesList, (clothesA, clothesB) -> {
            if (clothesA.getSize() > clothesB.getSize()) {
                return 1;
            } else {
                return -1;
            }
        });
    }

    public List<Clothes> getList() {
        return this.clothesList;
    }

}
