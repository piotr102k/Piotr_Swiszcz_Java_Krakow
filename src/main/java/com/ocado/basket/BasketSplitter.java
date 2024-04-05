package com.ocado.basket;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
            System.out.println("error 404 file not found");
        }

    }
    public Map<String,List<String>> split(List<String> items){
        Map<String,List<String>> splitResult=new HashMap<>();
        for (String item:items) {
            System.out.println(jsonConfigFile.get(item));
        }
        return splitResult;
    }
}
