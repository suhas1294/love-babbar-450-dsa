package rishi.atreya._03_strings;

import java.util.Comparator;
import java.util.PriorityQueue;

class KeyComparator implements Comparator<Key> {
    public int compare(Key k1, Key k2){
        if (k1.freq < k2.freq) return 1;
        else if (k1.freq > k2.freq) return -1;
        return 0;
    }
}

class Key {
    int freq; // store frequency of character
    char ch;
    Key(int val, char c){
        freq = val;
        ch = c;
    }
}

public class _78_RearranceCharsNoTwoAdjSame {
    static int MAX_CHAR = 26;
    // Function to rearrange character of a string so that no char repeat twice
    static void rearrangeString(String str){
        int n = str.length();
        int[] count = new int[MAX_CHAR];
        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;

        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0) pq.add(new Key(count[val], c));
        }

        str = ""; //  resultant value

        // work as the previous visited element initial previous element be.
        // ( '#' and it's frequency '-1' )
        Key prev = new Key(-1, '#');

        while (pq.size() != 0) {
            Key k = pq.peek();
            pq.poll();
            str += k.ch;
            if (prev.freq > 0) pq.add(prev); // useless if < 0
            (k.freq)--;
            prev = k;
        }

        if (n != str.length()) System.out.println(" Not valid String ");
        else System.out.println(str);
    }

    public static void main(String[] args) {
        String str = "bbbaa";
        rearrangeString(str);
    }
}

