package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ClothesTest {
    private Clothes testClothes;

    @BeforeEach
    void runBefore() {
        testClothes = new Clothes("polo", 4, 35, "top");
    }

    @Test
    void testClothesConstructor() {
        assertEquals("polo", testClothes.getName());
        assertEquals(4, testClothes.getSize());
        assertEquals(35, testClothes.getPrice());
        assertEquals("top", testClothes.getCategory());
    }

    @Test
    void
}

