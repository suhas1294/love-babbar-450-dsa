package rishi.atreya._04_searching_and_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/kth-smallest-number-again-2/
public class _108_KthSmallestNoAgain {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            ArrayList < ArrayList<Long> > list = new ArrayList<> ();
            for (int i = 0; i < n; i++) {
                ArrayList < Long > al = new ArrayList < > ();
                long a = sc.nextLong();
                long b = sc.nextLong();
                al.add(a);
                al.add(b);
                list.add(al);
            }
            Collections.sort(list, (l1, l2) -> l1.get(0).compareTo(l2.get(0)) );
            int idx = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).get(0) <= list.get(idx).get(1)) {
                    list.get(idx).set(1,
                            Math.max(
                                list.get(idx).get(1),
                                list.get(i).get(1))
                    );
                } else {
                    idx++;
                    list.set(idx, list.get(i));
                }
            }

            while (q-- > 0) {
                boolean isFound = false;
                long k = sc.nextLong();
                for (int i = 0; i <= idx; i++) {
                    long diff = list.get(i).get(1) - list.get(i).get(0);
                    if (k <= diff + 1) {
                        System.out.println(list.get(i).get(0) + k - 1);
                        isFound = true;
                        break;
                    } else {
                        k = k - diff - 1;
                    }
                }
                if (!isFound) {
                    System.out.println(-1);
                }
            }

        }
    }
}
