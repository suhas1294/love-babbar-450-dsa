package rishi.atreya._02_matrix;

import java.util.Arrays;

public class _44_KthSmallestInRowColSortedMatrix {

    static int kthSmallest(int[][]mat,int n,int k){
        int[] a=new int[n*n];
        int v=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[v]=mat[i][j];
                v++;
            }
        }
        Arrays.sort(a);
        int result=a[k-1];
        return result;
    }

    public static void main (String[] args) {
        int mat[][] = { { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 25, 29, 37, 48 },
                { 32, 33, 39, 50 } };
        int res = kthSmallest(mat, 4, 7);
        System.out.print("7th smallest element is "+ res);
    }
}
