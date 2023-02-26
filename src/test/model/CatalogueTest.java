package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class CatalogueTest {
    private Catalogue testCatalogue;

    @BeforeEach
    void setUp() {
        testCatalogue = new Catalogue();
    }

    @Test
    void testCatalogueConstructor() {
        assertTrue( testCatalogue.getList().isEmpty());
    }

    @Test
    void testAddOneItem() {
        testCatalogue.addClothes("miniskirt", 6, 50, "bottom");
        assertEquals(1, testCatalogue.getList().size());
        assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
    }

    @Test
    void testAddMultiple() {
       testCatalogue.addClothes("miniskirt", 6, 50, "bottom");
       testCatalogue.addClothes("cami", 2, 12, "top");
       testCatalogue.addClothes("harley-davidson jacket", 75, 50, "outerwear");
       assertEquals(3, testCatalogue.getList().size());
       assertEquals("miniskirt", testCatalogue.getList().get(0).getName());
       assertEquals("cami", testCatalogue.getList().get(1).getName());
       assertEquals("harley-davidson jacket", testCatalogue.getList().get(2).getName());
    }

    @Test
    void testSortPrice() {
        testCatalogue.addClothes("miniskirt", 6, 50, "bottom");
        testCatalogue.addClothes("cami", 2, 12, "top");
        testCatalogue.addClothes("harley-davidson jacket", 75, 98, "outerwear");
        testCatalogue.sortPrice();
        assertEquals("miniskirt", testCatalogue.getList().get(1).getName());
        assertEquals("cami", testCatalogue.getList().get(0).getName());
        assertEquals("harley-davidson jacket", testCatalogue.getList().get(2).getName());
    }

    @Test
    void testSortSize() {
        testCatalogue.addClothes("miniskirt", 6, 50, "bottom");
        testCatalogue.addClothes("cami", 2, 12, "top");
        testCatalogue.addClothes("harley-davidson jacket", 14, 98, "outerwear");
        testCatalogue.addClothes("legwarmers",0, 5, "accessories");
        testCatalogue.sortSize();
        assertEquals("miniskirt", testCatalogue.getList().get(2).getName());
        assertEquals("cami", testCatalogue.getList().get(1).getName());
        assertEquals("harley-davidson jacket", testCatalogue.getList().get(3).getName());
        assertEquals("legwarmers", testCatalogue.getList().get(0).getName());

    }

}