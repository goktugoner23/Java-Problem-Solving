import javax.swing.text.AttributeSet;
import java.util.*;

/*https://leetcode.com/problems/ransom-note/
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.*/
public class RansomNoteConstruct {
    public static boolean canConstruct(String ransomNote, String magazine){
        if(magazine == null || (magazine.equals("") && !ransomNote.equals(""))){
            return false;
        }
        if(ransomNote.equals(magazine)){
            return true;
        }
        Map<Character, Integer> ransomList = new HashMap<>();
        Map<Character, Integer> magazineList = new HashMap<>();
        for(int i = 0; i < ransomNote.length(); i++){
            if(ransomList.get(ransomNote.charAt(i)) != null){
                int occur = ransomList.get(ransomNote.charAt(i)) + 1;
                ransomList.put(ransomNote.charAt(i), occur);
            }else{
                ransomList.put(ransomNote.charAt(i), 1);
            }
        }
        for(int i = 0; i < magazine.length(); i++){
            if(magazineList.get(magazine.charAt(i)) != null){
                int occur = magazineList.get(magazine.charAt(i)) + 1;
                magazineList.put(magazine.charAt(i), occur);
            }else{
                magazineList.put(magazine.charAt(i), 1);
            }
        }
        for(Map.Entry<Character,Integer> item : ransomList.entrySet()){
            int ransomListValue = item.getValue();
            if(magazineList.containsKey(item.getKey())){
                if(magazineList.get(item.getKey()) < ransomListValue){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

    /*ONE HASHMAP SOLUTION
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> m  = new HashMap<>();

        for(Character c : magazine.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) +1);
        }

        for(Character c : ransomNote.toCharArray()){

            m.put(c, m.getOrDefault(c, 0) - 1);

            if(m.get(c) <0){
                return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        System.out.println(canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}
