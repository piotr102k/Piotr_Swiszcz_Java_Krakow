package com.ocado.basket;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DeliveryMethods {
    public String name;
    public JSONArray methods;
    public boolean accountedFor;
    public DeliveryMethods(String name,JSONArray methods){
        this.name=name;
        this.methods=methods;
        this.accountedFor=false;
    }
}
