package com.ocado.basket;

import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;

public class BasketSplitter {
    JSONObject jsonConfigFile;
    public BasketSplitter(String absolutePathToConfigFile){
        try {
            Scanner scan = new Scanner(new File(absolutePathToConfigFile));
            String inputString = new String();
            while (scan.hasNext()) {
                inputString+=scan.nextLine();
            }
            scan.close();
            jsonConfigFile=new JSONObject(inputString);
        } catch(FileNotFoundException e){

        }

    }
    public Map<String,List<String>> split(List<String> items){
        Map<String,List<String>> splitResult=new LinkedHashMap<>();
        List<DeliveryMethods> allDeliverMethods=new ArrayList<>();

        if(items.size()==0 || items.size()>100){
            return new HashMap<>();
        }


        for (String item:items) {
            try {
                JSONArray deliveryMethods = (JSONArray) jsonConfigFile.get(item);
                allDeliverMethods.add(new DeliveryMethods(item, deliveryMethods));
            }catch (org.json.JSONException e){

            }

        }

        Integer numberOfAcountedForItems=0;
        while(numberOfAcountedForItems!=allDeliverMethods.size()){
            List<String> distinctDeliveryMethods=makeDistinctList(allDeliverMethods);
            List<String> deliveredItems=new ArrayList<>();

            String MostUsedDeliveryMethod=FindMostUsedDeliveryMethod(allDeliverMethods,distinctDeliveryMethods);

            for(DeliveryMethods deliveryMethod: allDeliverMethods){

                if(deliveryMethod.contains(MostUsedDeliveryMethod) && deliveryMethod.accountedFor==false){
                    deliveredItems.add(deliveryMethod.name);
                    deliveryMethod.accountedFor=true;
                    numberOfAcountedForItems++;
                }
            }

            splitResult.put(MostUsedDeliveryMethod,deliveredItems);
        }

        return splitResult;
    }
    public String FindMostUsedDeliveryMethod(List<DeliveryMethods> allMethods,List<String> distinctMethods){
        List<Integer> correspondingNumberOfUseCases=new ArrayList<>();
        for(Integer i=0;i!=distinctMethods.size();i++)
            correspondingNumberOfUseCases.add(0);

        for(DeliveryMethods deliveryMethod:allMethods){
            for(Integer i=0;i!=deliveryMethod.methods.length();i++){
                if( deliveryMethod.accountedFor==false)
                    correspondingNumberOfUseCases.set(distinctMethods.indexOf(deliveryMethod.methods.get(i)),correspondingNumberOfUseCases.get(distinctMethods.indexOf(deliveryMethod.methods.get(i)))+1);
            }
        }

        Integer maxNumberOfUseCases=Collections.max(correspondingNumberOfUseCases);
        return distinctMethods.get(correspondingNumberOfUseCases.indexOf(maxNumberOfUseCases));
    }
    public List<String> makeDistinctList(List<DeliveryMethods> allMethods){
        List<String> distinctList=new ArrayList<>();

        for(DeliveryMethods deliveryMethods:allMethods){
            for(Integer i=0;i!=deliveryMethods.methods.length();i++){
                if(!distinctList.contains(deliveryMethods.methods.get(i)) && deliveryMethods.accountedFor==false){
                    distinctList.add(deliveryMethods.methods.get(i).toString());
                }
            }
        }

        return distinctList;
    }
}
