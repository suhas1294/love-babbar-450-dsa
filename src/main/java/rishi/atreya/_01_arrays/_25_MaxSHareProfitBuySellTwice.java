package rishi.atreya._01_arrays;

public class _25_MaxSHareProfitBuySellTwice {
    static int maxProfit(int price[], int arr_len) {
        // Create profit array and initialize it as 0
        int profit[] = new int[arr_len];
        for (int i = 0; i < arr_len; i++) profit[i] = 0;

        // Get the maximum profit with only one transaction allowed. After this loop,
        // profit[i] contains maximum profit from price[i..n-1] using at most one trans.
        int max_price = price[arr_len - 1];

        for (int i = arr_len - 2; i >= 0; i--) {
            // max_price has maximum of price[i..n-1]
            if (price[i] > max_price) max_price = price[i];
            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at max_price
            profit[i] = Math.max(profit[i + 1], max_price - price[i]);
        }

        // Get the maximum profit with two transactions allowed After this loop, profit[n-1]
        // contains the result
        int min_price = price[0];
        for (int i = 1; i < arr_len; i++) {
            // min_price is minimum price in price[0..i]
            if (price[i] < min_price) min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add profit of other
            // trans stored in profit[i]
            profit[i] = Math.max(
                    profit[i - 1],
                    profit[i] + (price[i] - min_price)
            );
        }
        int result = profit[arr_len - 1];
        return result;
    }
}
