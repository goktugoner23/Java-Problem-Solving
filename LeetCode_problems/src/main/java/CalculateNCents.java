/*Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
write code to calculate the number of ways of representing n cents.*/
package main.java;

import java.util.*;

public class CalculateNCents {
    public static Set<List<Integer>> getSets(int n, int currentCoin) {
        Set<List<Integer>> sets = new HashSet<>();
        int[] coins = {25, 10, 5, 1};
        if (n == 0) {
            sets.add(new ArrayList<>());
            return sets;
        }
        if (n < 0 || currentCoin == coins.length) {
            return sets;
        }

        Set<List<Integer>> subSets = getSets(n, currentCoin + 1);
        sets.addAll(subSets);

        int currentValue = coins[currentCoin];
        for (int i = 0; i * currentValue <= n; i++) {
            Set<List<Integer>> subSetsWithCurrentCoin = getSets(n - i * currentValue, currentCoin + 1);
            for (List<Integer> subSet : subSetsWithCurrentCoin) {
                for (int j = 0; j < i; j++) {
                    subSet.add(currentValue);
                }
                sets.add(subSet);
            }
        }
        return sets;
    }

    public static void main(String[] args) {
        int n = 10;
        Set<List<Integer>> sets = getSets(n, 0);
        for (List<Integer> set : sets) {
            System.out.println(set);
        }
        System.out.println(sets.size());
    }
}
