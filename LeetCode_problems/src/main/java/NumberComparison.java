/*Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
EXAMPLE
Input: 5, 10
Output: 10*/

package main.java;

public class NumberComparison {
    public static int CompareNumbers(int a, int b){
        int c = a - b;
        int k = (c >> 31) & 0x1;
        int max = a - k * c;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(CompareNumbers(12,5));
    }
}
