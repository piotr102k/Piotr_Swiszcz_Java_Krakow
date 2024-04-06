package com.ocado.basket;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeliveryMethods {
    public String name;
    public JSONArray methods;
    public boolean accountedFor;
    public DeliveryMethods(String name,JSONArray methods){
        this.name=name;
        this.methods=methods;
        this.accountedFor=false;
    }
    public boolean contains(String string){
        boolean doesItContainString=false;
        for(Integer i=0;i!=methods.length();i++){
            if(Objects.equals(methods.get(i).toString(), string)){
                doesItContainString=true;
            }
        }
        return doesItContainString;
    }
}
