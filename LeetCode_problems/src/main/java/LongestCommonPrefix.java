/*https://leetcode.com/problems/longest-common-prefix/
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.*/

package main.java;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return ""; //error condition.
        List<List<Character>> bigList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) { //add the strings to a list of lists
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < strs[i].length(); j++) {
                list.add(strs[i].charAt(j));
            }
            bigList.add(list);
        }
        List<Character> prefixList = bigList.get(0);
        for (int i = 1; i < bigList.size(); i++) {
            while (!bigList.get(i).containsAll(prefixList)) {
                prefixList.remove(prefixList.size() - 1);
                if (prefixList.size() == 0) {
                    return "";
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character var: prefixList) {
            result.append(var);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa","ab"}));
    }
}
