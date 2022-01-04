package rishi.atreya._04_searching_and_sorting;

import java.util.Scanner;

// https://www.spoj.com/problems/ANARC05B/

public class _119_DoubleHelixSPOJ {
    public static void main(String[] args) {
        int n,m;
        Scanner scanner = new Scanner(System.in);

        while( true ) {
            int max_till_now = 0;
            int sum1=0, sum2=0;
            n = scanner.nextInt();

            if(n==0) break;
            int[] arr1 = new int[n];

            for( int x=0; x<n; x++ )
                arr1[x] = scanner.nextInt();

            m = scanner.nextInt();
            int[] arr2 = new int[m];
            for( int x=0; x<m; x++ )
                arr2[x] = scanner.nextInt();

            int j=0, i=0;

            for( i=0; i<n; i++ ) {
                sum1 += arr1[i];
                int start = j, end = m-1, mid = 0;
                boolean flag = false;

                while( start<=end ) {
                    mid = start + (end-start)/2;

                    if( arr1[i]==arr2[mid] ) {
                        flag = true;
                        break;
                    }else if( arr1[i]>arr2[mid] ) {
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }

                if( flag ) {
                    int k;
                    for( k=j; k <= mid; k++ )
                        sum2 += arr2[k];
                    j=k;
                    max_till_now += Math.max( sum1, sum2 );
                    sum1=0; sum2=0;
                }
                //flag = false;
            }

            for( int x=j; x<m; x++ ) {
                sum2 += arr2[x];
            }

            max_till_now += Math.max( sum2, sum1);
            System.out.println(max_till_now);
        }

    }
}
