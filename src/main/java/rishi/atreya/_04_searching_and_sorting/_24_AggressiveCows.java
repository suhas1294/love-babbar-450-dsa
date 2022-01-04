package rishi.atreya._04_searching_and_sorting;

import java.util.Arrays;
import java.util.Scanner;

// https://www.spoj.com/problems/AGGRCOW/
// https://rushyab.medium.com/aggressive-cows-spoj-75a155bfe749
public class _24_AggressiveCows {
    public static void main(String[] args){

        Scanner scn=new Scanner(System.in);
        int times=scn.nextInt();
        int size=scn.nextInt();
        int cows=scn.nextInt();
        int[] arr=new int[size];

        for(int i=0;i<size;i++){
            arr[i]=scn.nextInt();
        }
        Arrays.sort(arr);

        while(times-->0) {
            int low=0,high=arr[size-1],ans=0;
            while(low<=high){
                int mid=(low+high+1)/2;
                int cowsplaced=1;
                int lastposition=0;

                for(int i=1;i<size&&cowsplaced<cows;i++){
                    if(arr[i]-arr[lastposition]>=mid){
                        cowsplaced++;
                        lastposition=i;
                    }
                }

                if(cows==cowsplaced){
                    ans=mid;
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            System.out.println(ans);
            scn.close();
        }
    }
}

// Time Complexity: O(NlogN), Space Complexity: O(N); Where N ≤ 100000.