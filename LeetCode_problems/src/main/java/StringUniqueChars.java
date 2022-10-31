package main.java;

import java.io.*;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;
//implement a function that returns all the unique chars in a given string
public class StringUniqueChars {
    public static int uniqueChars(String s){
        if(s == null || s.equals("")){
            return 0;
        }
        Set<Character> charset = new LinkedHashSet<>();
        String lowerCase = s.toLowerCase();
        for(int i = 0; i < lowerCase.length(); i++){
            charset.add(lowerCase.charAt(i));
        }
        //faster solution is Character.toLowerCase.charAt(i) inside the for loop but it lacks some of the letters because of localization
        charset.forEach(c -> System.out.print(c + " ")); //print the unique chars out of curiosity
        return charset.size();
    }
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        File file = new File(path + "\\src\\main\\resources\\loremipsum.txt");
        System.out.println(path + "\\src\\main\\resources\\loremipsum.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
        System.out.println(uniqueChars("Alperen"));
        System.out.println(uniqueChars("AlPeREn"));
        System.out.println(uniqueChars("Göktuğ"));
        System.out.println(uniqueChars("Göktug"));
        long begin = System.currentTimeMillis();
        System.out.println(uniqueChars(s));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        //130-160 ms runtime
        //l o r e m   i p s u d t a , c n g . q b f j v h y ; 26
    }
}

