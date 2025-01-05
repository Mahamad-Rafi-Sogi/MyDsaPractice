package com.rafi.practice;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        int result = minPathSum(grid);
        System.out.println("Minimum Path Sum: " + result);
    }
    
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];


        dp[0][0] = grid[0][0];

        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[rows - 1][cols - 1];
    }
	
}


/*
 
 Approach: DP
 
 Time Complexity:

	•	O(m * n): Each cell is visited once.

Space Complexity:

	•	O(m * n): Extra space for the dp array.
(Can be reduced to O(n) using a single row for computation.)
 
 */
