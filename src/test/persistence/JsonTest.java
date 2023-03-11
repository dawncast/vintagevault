package persistence;

import model.Clothes;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
        protected void checkClothingItem(String itemName, int itemSize, int itemPrice, String itemCategory, Clothes clothes) {
            assertEquals(itemName, clothes.getName());
            assertEquals(itemSize, clothes.getSize());
            assertEquals(itemPrice, clothes.getPrice());
            assertEquals(itemCategory, clothes.getCategory());

        }
    }

