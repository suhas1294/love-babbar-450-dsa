package rishi.atreya._02_matrix;

import java.util.ArrayList;

public class _43_RotateMatrixBy90Deg {
    public static void rotateMatixBy90Deg(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        // take transpose
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <= n-1; j++) {
                if (i != j){
                    int v1 = A.get(i).get(j);
                    int v2 = A.get(j).get(i);
                    A.get(i).set(j, v2);
                    A.get(j).set(i, v1);
                }
            }
        }

        // reverse each row
        for (ArrayList<Integer> row: A) {
            int left = 0;
            int right = row.size()-1;
            while (left < right){
                int temp = row.get(left);
                row.set(left, row.get(right));
                row.set(right, temp);
                left++;
                right--;
            }
        }

        // rotating ends, printing starts here.
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> row: A) {
            sb.append("[");
            for (int num: row) {
                sb.append(num + " ");
            }
            sb.append("] ");
        }

        System.out.println(sb);

        for (ArrayList<Integer> row: A) {
            System.out.print("[");
            for (int num: row) {
                System.out.print(num + " ");
            }
            System.out.print("] ");
        }
    }
}
