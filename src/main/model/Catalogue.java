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

    public void sortPrice() {
        Collections.sort(clothesList, (clothesA, clothesB) -> {
            if (clothesA.getPrice() > clothesB.getPrice()) {
                return 1;
            } else {
                return -1;
            }
        });
    }

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