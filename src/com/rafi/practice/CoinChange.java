package com.rafi.practice;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Fewest Coins: " + solution.coinChange(coins, amount));
    }
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Fill with a large value
        dp[0] = 0; // Base case

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        System.out.println(Arrays.toString(dp));
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/*
 
  Approach:DP
 

Time Complexity:

	•	O(n \times \text{amount}), where n is the number of coins.
	•	For each coin, iterate over the DP array from the coin’s value to amount.

Space Complexity:

	•	O(\text{amount}), due to the DP array.
*/