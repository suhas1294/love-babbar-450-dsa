package rishi.atreya._04_searching_and_sorting;

public class _12_MaxSumNo2ElementsAdj {
    static int FindMaxSum(int[] arr){
        int[] dp = new int[arr.length];
        if(arr.length == 1){
            return arr[0];
        }else if(arr.length == 2){
            return Math.max(arr[0],arr[1]);
        }else if(arr.length == 3){
            dp[0]=arr[0];
            dp[1]=arr[1];
            dp[2]=arr[2]+arr[0];
            return Math.max(dp[2],dp[0]);
        }else{
            dp[0]=arr[0];
            dp[1]=arr[1];
            dp[2]=arr[2]+arr[0];
            for(int i=3;i< arr.length;i++){
                dp[i] = arr[i] + Math.max(dp[i-2],dp[i-3]);
            }
            return Math.max( dp[arr.length - 1], dp[arr.length - 2]);
        }
    }

    public static void main(String[] args) {
        int t;
        int[] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(FindMaxSum(arr));
    }
}
