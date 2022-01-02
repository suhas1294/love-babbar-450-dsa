package rishi.atreya._03_strings;

import java.util.HashSet;

public class _73_FirstRepeatedWordInString {
    static String findFirstRepeated(String s){
        String token[] = s.split(" "); // break string into tokens
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<token.length; i++){ // store the words of string in hashset
            if(set.contains(token[i])) return token[i]; // if word exists return
            set.add(token[i]); // insert new word to set
        }
        return "NoRepetition";
    }

    public static void main(String[] args) {
        String s = "Ravi had been saying that he had been there";
        String firstWord = findFirstRepeated(s);
        if (!firstWord.equals("NoRepetition"))
            System.out.println("First repeated word :: " + firstWord);
        else
            System.out.println("No Repetitionn");
    }
}
