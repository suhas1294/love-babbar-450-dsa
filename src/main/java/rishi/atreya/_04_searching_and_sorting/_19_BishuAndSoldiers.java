package rishi.atreya._04_searching_and_sorting;

import java.util.Scanner;

// https://www.hackerearth.com/problem/algorithm/bishu-and-soldiers-227/
// prefix sum + binary search
public class _19_BishuAndSoldiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        while(t --> 0){ // https://stackoverflow.com/questions/29429605/what-does-mean-in-java
            int sum = 0,count = 0;
            int p = sc.nextInt();
            for(int i = 0;i<n;i++){
                if(arr[i] <= p){
                    sum += arr[i];
                    count++;
                }
            }
            System.out.println(count+" "+ sum);
        }
    }
}
