package com.ocado.basket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketSplitterTest {

    private BasketSplitter newBasket;
    Map<String,List<String>> result =new HashMap<>();
    //List<String> basket1 = Arrays.asList("Cocoa Butter", "Tart - Raisin And Pecan", "Table Cloth 54x72 White", "Flower - Daisies", "Fond - Chocolate", "Cookies - Englishbay Wht");
    //List<String> basket2 = Arrays.asList("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea");
    //List<String> emptyBasket = new ArrayList<>();
    @BeforeEach
    void setUp() {
        String pathToConfig="D:\\Wszystko\\ZadanieJava\\Zadanie\\config.json";
        newBasket = new BasketSplitter(pathToConfig);
    }

    @Test
    void testBasket2() {
        List<String> basket2 = Arrays.asList("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea");
        result=newBasket.split(basket2);
        assertEquals("{Express Collection=[Fond - Chocolate, Chocolate - Unsweetened, Nut - Almond, Blanched, Whole, Haggis, Mushroom - Porcini Frozen, Longan, Bag Clear 10 Lb, Nantucket - Pomegranate Pear, Puree - Strawberry, Apples - Spartan, Cabbage - Nappa, Bagel - Whole White Sesame, Tea - Apple Green Tea], Same day delivery=[Sauce - Mint, Numi - Assorted Teas, Garlic - Peeled], Courier=[Cake - Miini Cheesecake Cherry]}",result.toString());
    }

    @Test
    void testBasket1() {
        List<String> basket1 = Arrays.asList("Cocoa Butter", "Tart - Raisin And Pecan", "Table Cloth 54x72 White", "Flower - Daisies", "Fond - Chocolate", "Cookies - Englishbay Wht");
        result=newBasket.split(basket1);
        assertEquals("{Courier=[Cocoa Butter, Tart - Raisin And Pecan, Table Cloth 54x72 White, Flower - Daisies, Cookies - Englishbay Wht], Pick-up point=[Fond - Chocolate]}",result.toString());
    }

    @Test
    void emptyBasket1() {
        List<String> emptyBasket = new ArrayList<>();
        result=newBasket.split(emptyBasket);
        assertEquals("{}",result.toString());
    }




}