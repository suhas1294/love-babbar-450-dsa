package rishi.atreya._01_arrays;

public class _16_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;

        int min = prices[0]; // min so far
        int result = 0;

        for(int i=1; i<prices.length; i++){
            result = Math.max(result, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        System.out.println(maxProfit(price));
    }
}
