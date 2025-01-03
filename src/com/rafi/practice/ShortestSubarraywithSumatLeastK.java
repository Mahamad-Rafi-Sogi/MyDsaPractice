package com.rafi.practice;


public class ShortestSubarraywithSumatLeastK {

	public static void main(String[] args) {
        int[] nums1 = {2, -1, 2, 3, 1};
        int K1 = 4;
        System.out.println("Shortest Subarray Length: " + shortestSubarray(nums1, K1)); // Output: 2

        int[] nums2 = {1, 2};
        int K2 = 4;
        System.out.println("Shortest Subarray Length: " + shortestSubarray(nums2, K2)); // Output: -1
	}
	
    public static int shortestSubarray(int[] nums, int K) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            // Expand the window by adding nums[end]
            currentSum += nums[end];

            // Shrink the window while currentSum is greater than or equal to K
            while (currentSum >= K) {
                // Update the minimum length
                minLength = Math.min(minLength, end - start + 1);

                // Shrink the window
                currentSum -= nums[start];
                start++;
            }
        }

        // Return -1 if no valid subarray is found
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}

/*
Approach: Sliding Window (Two Pointers)

	1.	Time Complexity:  O(n) 
	•	The end pointer iterates through the array exactly once.
	•	The start pointer may iterate through the array, but it only moves forward (in total, both pointers make  n  moves).
	•	Overall, the time complexity is linear,  O(n) .
	
	2.	Space Complexity:  O(1) 
	•	No extra data structures are used; only a few integer variables (currentSum, start, etc.).

*/