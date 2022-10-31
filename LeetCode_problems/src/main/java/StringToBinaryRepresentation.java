//Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation. If the number can not be represented accurately in binary, print “ERROR”
package main.java;

import java.util.ArrayList;
import java.util.List;

public class StringToBinaryRepresentation {
    //without the toBinaryString function
    public static String stringToBinary(String s){
        if(s == null){
            return "ERROR";
        }
        StringBuilder binary = new StringBuilder();
        //check the string if its only numbers
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.'){
                return "ERROR";
            }
            if(s.charAt(i) == '.'){
                left = Integer.parseInt(s.substring(0, i));
                right = Integer.parseInt(s.substring(i+1));
            }
        }
        if(left != 0){
            binary.append(toBinary(left));
        }else{
            binary.append(toBinary(Integer.parseInt(s)));
        }
        if(right != 0){
            binary.append('.');
            binary.append(toBinary(right));
        }
        return binary.toString();
    }

    public static String toBinary(int n){
        if (n == 0){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        List<Integer> reverse = new ArrayList<>();
        while(n > 0){
            int remainder = n % 2;
            reverse.add(remainder);
            n >>= 1; //divide by 2
        }
        for(int i = reverse.size() - 1; i >= 0; i--){
            result.append(reverse.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringToBinary("7"));
    }
}
