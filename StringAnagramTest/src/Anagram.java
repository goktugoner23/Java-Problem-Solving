import java.util.HashMap;

//compare two strings decide if two strings are anagrams or not
//anagram: string you construct from another strings chars.
public class Anagram {
    public static boolean anagram(String word1, String word2) {
        if ((word1 == null || word2 == null) || word1.length() != word2.length()) {
            return false;
        }
        int length = word1.length();
        HashMap<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (table.containsKey(word1.charAt(i))) {
                int occurrence = table.get(word1.charAt(i)) + 1;
                table.put(word1.charAt(i), occurrence);
            }else{
                table.put(word1.charAt(i), 1);
            }
        }
        //compare with word2
        for (int i = 0; i < length; i++){
            if (table.containsKey(word2.charAt(i))){
                int occurrence = table.get(word2.charAt(i));
                if (occurrence == 1){
                    table.remove(word2.charAt(i));
                }else {
                    occurrence--;
                    table.put(word2.charAt(i), occurrence);
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(anagram("true", "false"));
    }
}
