//Given an Integer return it as a binary String.
package main.java;

import java.util.ArrayList;
import java.util.List;

public class IntegerToBinary {
    public static String intToBinary(int number){
        if (number == 0){
            return "0";
        }
        boolean isNegative = false;
        if(number < 0){
            isNegative = true;
            number = -number;
        }
        List<Integer> reverseArray = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        while(number > 0){
            reverseArray.add(number % 2);
            number = number / 2;
        }
        int size = reverseArray.size();
        for(int i = 0; i < 31 - size; i++){
            reverseArray.add(0);
        }
        if (isNegative) { //if its negative the most significant number should be 1
            reverseArray.add(1);
        }else{
            reverseArray.add(0);
        }
        for(int i = reverseArray.size() - 1; i >= 0; i--){
            result.append(reverseArray.get(i));
        }
        System.out.println(result.length());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToBinary(-256));
    }
}
