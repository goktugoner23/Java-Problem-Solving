/*https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.*/
package main.java;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>(); //we define a stack to add a parenthesis
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                charStack.push(s.charAt(i));
                continue; //we found an opening bracket and pushed it to the stack so we continue to the next char
            }else if (charStack.empty()) {
                return false;
            }
            Character top = charStack.pop(); //pop the stack and check the character if it's a closing bracket
            if(top == '(' && s.charAt(i) != ')'){ //and check if it's a true closing bracket
                return false;
            }
            if(top == '[' && s.charAt(i) != ']'){
                return false;
            }
            if(top == '{' && s.charAt(i) != '}'){
                return false;
            }
        } //so every opening bracket also has a closing one in the stack
        return charStack.empty(); //if the brackets match we return true, if not we return false
    }
}
