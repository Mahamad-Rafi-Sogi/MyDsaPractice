package com.rafi.practice;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};  // Example input
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Expected Output: 5 (Buy at 1, Sell at 6)
        
        int[] prices2 = {7, 1, 5, 2, 6, 1};  // Example input
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // Expected Output: 4 (Buy at 2, Sell at 6)
    
    }
    
    public static int maxProfit(int[] prices) {
        
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        
        for (int price : prices) {
            
            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;
  
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

}


/*

Approach:

	1.	Brute Force Approach: You could check every pair of days, one for buying and one for selling, and calculate the profit. This would take O(n^2) time complexity.
	2.	Optimized Approach (O(n)): The optimal way to solve this problem is by iterating through the list and keeping track of the minimum price seen so far. Then, for each day, calculate the potential profit if the stock were sold that day. Keep track of the maximum profit.
	
Time Complexity:

	•	O(n) where n is the length of the prices array, because we only traverse the list once.

Space Complexity:

	•	O(1) since we are only using a constant amount of extra space for variables (minPrice and maxProfit).



*/