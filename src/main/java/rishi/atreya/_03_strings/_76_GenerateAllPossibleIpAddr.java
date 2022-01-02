package rishi.atreya._03_strings;

import java.util.ArrayList;

public class _76_GenerateAllPossibleIpAddr {

    static void solve(String s, int i, int j, int level, String temp, ArrayList<String> res){
        if (i == (j + 1) && level == 5) {
            res.add(temp.substring(1));
        }

        // Digits of a number ranging 0-255 can lie only between 0-3
        for (int k = i; k < i + 3 && k <= j; k++) {
            int subStringLen =  k - i + 1;
            String ad = s.substring(i, i + subStringLen);
            // Return if sting starting with '0' or it is greater than 255.
            if (!ad.isEmpty() && (s.indexOf(i) == '0' || Long.parseLong(ad) > 255))
                return;
            // Recursively call for another level.
            solve(s, k + 1, j, level + 1, temp + '.' + ad, res);
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        int n = s.length();
        ArrayList<String> ans = new ArrayList<>();
        solve(s, 0, n - 1, 1, "", ans);
        for (String str : ans)
            System.out.println(str);
    }
}
