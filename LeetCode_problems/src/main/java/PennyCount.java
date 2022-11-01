//given an amount of money, calculate how many pennies required with the minimum number of pennies according to Turkish monetary system.
package main.java;

import java.util.HashMap;
import java.util.Map;

public class PennyCount {
    public static Map<Integer, Integer> pennyCount(int amount){
        //there are 4 types of pennies which are 1, 5, 25 and 50.
        Map<Integer,Integer> wallet = new HashMap<>();
        int fifty = 0;
        int twentyfive = 0;
        int one = 0;
        int five = 0;
        while(amount > 50){
            fifty ++;
            wallet.put(50, fifty);
            amount = amount - 50;
        }
        while(amount > 25){
            twentyfive ++;
            wallet.put(25, twentyfive);
            amount = amount - 25;
        }
        while(amount > 5){
            five ++;
            wallet.put(5, five);
            amount = amount - 5;
        }
        while(amount >= 1){
            one++;
            wallet.put(1, one);
            amount--;
        }
        return wallet;
    }

    //A faster version after a while of thinking lol
    public static Map<Integer, Integer> pennyCount2(int amount){
        //there are 4 types of pennies which are 1, 5, 25 and 50.
        Map<Integer,Integer> wallet = new HashMap<>();
        while(amount > 50){
            wallet.put(50, amount/50);
            amount -= 50 * (amount/50);
        }
        while(amount > 25){
            wallet.put(25, amount/25);
            amount -= 25 * (amount/25);
        }
        while(amount > 5){
            wallet.put(5, amount/5);
            amount -= 5 * (amount/5);
        }
        while(amount >= 1){
            wallet.put(1, amount);
            amount -= 1;
        }
        return wallet;
    }

    public static void main(String[] args) {
        System.out.println("number: " + 1726457161);
        long begin = System.currentTimeMillis();
        System.out.println(pennyCount(1726457161));
        long end = System.currentTimeMillis();
        System.out.println(end - begin + " miliseconds");
        long begin2 = System.currentTimeMillis();
        System.out.println(pennyCount2(1726457161));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2 + " miliseconds");
    }
}
