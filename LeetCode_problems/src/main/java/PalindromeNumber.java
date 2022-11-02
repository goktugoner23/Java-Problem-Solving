/*https://leetcode.com/problems/palindrome-number/
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.*/
package main.java;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        //negative numbers are not palindrome
        if(x < 0){
            return false;
        }
        //single digit and positive is always palindrome
        if(x <= 9){
            return true;
        }
        if(x == Integer.MAX_VALUE){ //Max value of an integer is not a palindrome
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int temp = x; //temporary variable for reversal
        while(temp != 0){
            int remainder = temp % 10;
            list.add(remainder);
            temp = temp / 10;
        }
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i) * Math.pow(10, list.size() - 1 - i); //construct the sum of the palindrome number
        }
        return sum == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
