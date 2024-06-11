package main.java;

import java.util.HashMap;
import java.util.Map;

public class studiothreetexample {
    public static Map<String, Integer> stringCheck(String s){
        String[] list = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String st : list){
            if(map.containsKey(st)){
                map.put(st, map.get(st) + 1);
            }else{
                map.put(st, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(stringCheck("Table Fox Table House Dog"));
    }
}
