package com.ocado.basket;


import java.util.Arrays;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        String pathToConfig="D:\\Wszystko\\ZadanieJava\\Zadanie\\config.json";
        BasketSplitter newBasket=new BasketSplitter(pathToConfig);
        List<String> basket1 = Arrays.asList("Cocoa Butter", "Tart - Raisin And Pecan", "Table Cloth 54x72 White", "Flower - Daisies", "Fond - Chocolate", "Cookies - Englishbay Wht");
        List<String> basket2 = Arrays.asList("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea");


        System.out.println(newBasket.split(basket1));

    }
}