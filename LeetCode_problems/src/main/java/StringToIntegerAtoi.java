/*https://leetcode.com/problems/string-to-integer-atoi/
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:
Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:
Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Example 1:
Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
^
Step 3: "42" ("42" is read in)
^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
Example 2:
Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
^
Step 2: "   -42" ('-' is read, so the result should be negative)
^
Step 3: "   -42" ("42" is read in)
^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
Example 3:
Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.

Constraints:
0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.*/
package main.java;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerAtoi {
    public static int myAtoi(String s) {
        List<Character> charList = new ArrayList<>();
        boolean isNegative = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                if(s.charAt(i) == '-'){
                    isNegative = true;
                    charList.add(s.charAt(i));
                    continue;
                }
                if(s.charAt(i) == '+'){
                    charList.add(s.charAt(i));
                    continue;
                }
                if(!Character.isDigit(s.charAt(i))){
                    if(charList.isEmpty()){
                        return 0;
                    }else{
                        break;
                    }
                }else if(Character.isDigit(s.charAt(i))){
                    charList.add(s.charAt(i));
                }
            }
            //    words and 987
        }
        int counter = 0;
        for(int i = 0; i < charList.size(); i++){
            if(charList.get(i) == '-' || charList.get(i) == '+'){
                counter++;
            }
        }
        if(counter > 1){
            return 0;
        }
        List<Integer> numbers = convertToInt(charList);
        int j = numbers.size() - 1;
        long sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i) * Math.pow(10, j);
            j--;
            if(sum >= Integer.MAX_VALUE){
                sum = Integer.MAX_VALUE;
                break;
            }
        }
        if(isNegative){
            if(sum == Integer.MAX_VALUE){
                sum++;
            }
            sum *= -1;
        }
        return (int)sum;
    }

    public static List<Integer> convertToInt(List<Character> list){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            switch (list.get(i)){
                case '0':
                    result.add(0);
                    break;
                case '1':
                    result.add(1);
                    break;
                case '2':
                    result.add(2);
                    break;
                case '3':
                    result.add(3);
                    break;
                case '4':
                    result.add(4);
                    break;
                case '5':
                    result.add(5);
                    break;
                case'6':
                    result.add(6);
                    break;
                case '7':
                    result.add(7);
                    break;
                case '8':
                    result.add(8);
                    break;
                case '9':
                    result.add(9);
                    break;
                case '-':
                case '+':
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String asd = "-12";
        System.out.println(myAtoi(asd));
    }
}
