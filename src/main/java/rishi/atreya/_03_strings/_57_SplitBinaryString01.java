package rishi.atreya._03_strings;

public class _57_SplitBinaryString01 {
    static int maxSubStr(String str){
        int n = str.length();
        int count0 = 0, count1 = 0;
        // To store the count of maximum
        // substrings str can be divided into
        int cnt = 0;
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == '0') count0++;
            else count1++;
            if (count0 == count1)cnt++;
        }
        if (count0 != count1) return -1; // It is not possible to split the string
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(maxSubStr("0100110101"));
    }
}
