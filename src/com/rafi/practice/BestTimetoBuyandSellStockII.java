package com.rafi.practice;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        
        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 7 (buy at 1, sell at 5, buy at 3, sell at 6)

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices2)); // Output: 4 (buy at 1, sell at 5)
        
        // Example 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices3)); // Output: 0 (no profit can be made)
    }
    
    public static int maxProfit(int[] prices) {
        int profit = 0;
        
        // Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If the price is higher than the previous day, we make a profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
