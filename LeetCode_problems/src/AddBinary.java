/*https://leetcode.com/problems/add-binary/
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.*/

public class AddBinary {
    public static String addBinary(String a, String b) {
        if(a == null || b == null){
            return null;
        }
        int length = 0;
        StringBuilder result = new StringBuilder();
        if(a.length() > b.length()){
            while(a.length() != b.length()){
                b = "0" + b;
            }
        }else{
            while(a.length() != b.length()){
                a = "0" + a;
            }
        }
        length = a.length();
        int carry = 0;
        for(int i = length - 1; i >=0; i--){
            if ((a.charAt(i) == '1' && b.charAt(i) == '0') || ((a.charAt(i) == '0' && b.charAt(i) == '1'))){
                if (carry == 0) {
                    result.insert(0, '1');
                } else {
                    result.insert(0, '0');
                }
            } else if (a.charAt(i) == '0' && b.charAt(i) == '0') {
                if (carry == 0) {
                    result.insert(0, '0');
                } else {
                    result.insert(0, '1');
                    carry = 0;
                }
            } else if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (carry == 0) {
                    result.insert(0, '0');
                    carry = 1;
                } else {
                    result.insert(0, '1');
                }
            }
        }
        if (carry == 1) {
            result.insert(0, '1');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "01"));
    }
    //sum with carriage
}
