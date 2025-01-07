package com.rafi.practice;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {

        // Example 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1));  // Output: 2

        // Example 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2));  // Output: 2
    }
    
    public static int subarraySum(int[] nums, int k) {
        // HashMap to store the frequency of cumulative sums
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // There's one way to have a sum of 0 (empty subarray)

        int count = 0;   // To store the result (number of subarrays)
        int currentSum = 0;

        // Traverse through the array
        for (int num : nums) {
            currentSum += num;  // Update the cumulative sum

            // Check if there is a subarray with sum k
            if (map.containsKey(currentSum - k)) {
                count += map.get(currentSum - k);  // Add the frequency of (currentSum - k)
            }

            // Update the frequency of the current sum in the hashmap
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}


/*

Optimized Approach (using HashMap):


Time Complexity:

	•	O(n): We traverse the array once, and for each element, checking and updating the hashmap takes constant time.
	•	Space Complexity: O(n) for storing the cumulative sums in the hashmap.
*/