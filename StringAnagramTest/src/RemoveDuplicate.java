import java.util.*;

//design an algorithm that removes duplicate characters in a string
public class RemoveDuplicate {
    public static String removeDuplicate(String word){
        if (word == null){
            return null;
        }
        if (word.equals("")){
            return "";
        }
        LinkedHashMap<Character, Integer> table = new LinkedHashMap<>();
        int length = word.length();
        for(int i = 0; i < length; i++){
            int occurrence = word.charAt(i) + 1;
            if(table.containsKey(word.charAt(i))){
                table.put(word.charAt(i), occurrence);
            }else{
                table.put(word.charAt(i), 1);
            }
        }
        StringBuilder finalWord = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : table.entrySet()){
            finalWord.append(entry.getKey());
        }
        return finalWord.toString();
    }

    public static String removeDuplicate2(String word){
        if (word == null){
            return null;
        }
        if (word.equals("")){
            return "";
        }
        int length = word.length();
        StringBuilder finalWord = new StringBuilder();
        finalWord.append(word.charAt(0));
        for(int i = 1; i < length; i++){ //length=7
            int j;
            for(j = 0; j < finalWord.length(); j++){
                if(word.charAt(i) == finalWord.charAt(j)){
                    break;
                }
            }
            if(j == finalWord.length()){
                finalWord.append(word.charAt(i));
            }
        }
        return finalWord.toString(); //reb
    }

    public static String removeDuplicate3(String word){
        if (word == null){
            return null;
        }
        if (word.equals("")){
            return "";
        }
        int length = word.length();
        Set<Character> charSet = new HashSet<>();
        StringBuilder finalWord = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(!charSet.contains(word.charAt(i))){
                finalWord.append(word.charAt(i));
            }
            charSet.add(word.charAt(i));
        }
        return finalWord.toString();
    }

    public static String removeDuplicate4(String word){
        if (word == null){
            return null;
        }
        if (word.equals("")){
            return "";
        }
        int length = word.length();
        Set<Character> charSet = new LinkedHashSet<>();
        for(int i = 0; i < length; i++){
            charSet.add(word.charAt(i));
        }
        return charSet.toString();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(removeDuplicate("rebecca"));
        System.out.println(removeDuplicate2("rebecca"));
        System.out.println(removeDuplicate3("rebecca"));
        System.out.println(removeDuplicate4("rebecca"));
        long finish = System.nanoTime();
        System.out.println(finish - start);
    }
}
