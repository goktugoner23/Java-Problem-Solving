package main.java;

import java.util.HashMap;

public class FibMemo {
    //we create a hashmap to store the values for the values that are calculated before
    //Time complexity of normal Fibonacci tree would be O(n^2) and space complexity of O(n).
    //But this dynamically programmed Fib Tree will have time and space complexity of O(n).
    public HashMap<Integer, Integer> memo = new HashMap<>();
    public int fib(int n, HashMap<Integer, Integer> memo){
        if(n <= 2){
            return 1;
        }
        //if we calculated the values before we dont need them to calculate again so we return it
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }
}
