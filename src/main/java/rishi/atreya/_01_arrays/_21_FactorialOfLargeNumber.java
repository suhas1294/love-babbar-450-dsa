package rishi.atreya._01_arrays;

import java.util.ArrayList;
import java.util.List;

public class _21_FactorialOfLargeNumber {
    private static List<Integer> getFact(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= n; i++)
            multiply(ans, i);
        return ans;
    }

    private static void multiply(List<Integer> a, int n) {
        int carry = 0;
        for (int k = a.size() - 1; k >= 0; k--) {
            int pro = n * a.get(k) + carry;
            int val = pro % 10;
            a.set(k, val);
            carry = pro / 10;
        }
        while (carry != 0) {
            a.add(0, carry % 10);
            carry /= 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFact(15));
    }

}
