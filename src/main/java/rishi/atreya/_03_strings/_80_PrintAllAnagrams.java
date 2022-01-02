package rishi.atreya._03_strings;

import java.util.ArrayList;
import java.util.HashMap;

public class _80_PrintAllAnagrams {
    private static ArrayList<ArrayList<String>> solver(ArrayList<String> list){
        // Inner hashmap counts frequency of characters in a string.
        // Outer hashmap for if same frequency characters are present in
        // in a string then it will add it to the arraylist.
        HashMap< HashMap<Character, Integer>, ArrayList<String> > map = new HashMap<>();
        for (String str : list) {
            HashMap<Character, Integer> tempMap = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                }else {
                    tempMap.put(str.charAt(i), 1);
                }
            }

            if (map.containsKey(tempMap)) {
                map.get(tempMap).add(str);
            }else {
                ArrayList<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }

        ArrayList<ArrayList<String> > result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet()) {
            result.add(map.get(temp));
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");

        System.out.println(solver(list));
    }
}
