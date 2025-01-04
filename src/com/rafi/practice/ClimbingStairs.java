package com.rafi.practice;

import java.util.ArrayList;

public class ClimbingStairs {
	
	private static ArrayList<Integer> dp = new ArrayList<>();
	
    static {
        dp.add(0); // Placeholder for 0 steps
        dp.add(1); // Base case: 1 way to climb 1 step
        dp.add(2); // Base case: 2 ways to climb 2 steps
    }
	
	public static void main(String[] args) {
        int n1 = 5;
        int n2 = 10;

        System.out.println("Ways to climb 5 steps: " + climbStairs(n1)); // Output: 8
        System.out.println("Ways to climb 10 steps: " + climbStairs(n2)); // Output: 89
		
	}
	
    public static int climbStairs(int n) {
        // Check if the result for `n` is already present
        if (n < dp.size()) {
            return dp.get(n); // Return the precomputed value
        }

        // Compute and store values up to `n`
        for (int i = dp.size(); i <= n; i++) {
            dp.add(dp.get(i - 1) + dp.get(i - 2));
        }

        return dp.get(n); // Return the result for `n`
    }

}

/*
Approach

	1.	Base Cases:
	•	If  n = 1 : Only one way to climb (one step).
	•	If  n = 2 : Two ways to climb (1+1 or 2).
	2.	Recursive Relationship:
	•	To reach the  i^{th}  step, you could have:
	•	Come from the  (i-1)^{th}  step (1 step before).
	•	Come from the  (i-2)^{th}  step (2 steps before).
	•	Formula:
 		dp[i] = dp[i-1] + dp[i-2] .
	3.	Iterative Approach:
	•	Use an array  dp[]  where  dp[i]  represents the number of ways to reach step  i .
	•	Initialize  dp[1] = 1 ,  dp[2] = 2 , and compute up to  dp[n] .
	4.	Optimized Space:
	•	Instead of using an array, store only the last two values, as the current value depends only on the previous two.
	
	
Complexity

	1.	Time Complexity:
 O(n)  — We iterate from  3  to  n .
	2.	Space Complexity:
 O(1)  — Only a few variables are used to store intermediate results.

*/

