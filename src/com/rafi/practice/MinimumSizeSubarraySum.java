package com.rafi.practice;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println("Minimum Subarray Length: " + minSubArrayLen(target1, nums1)); // Output: 2

        int[] nums2 = {1, 4, 4};
        int target2 = 8;
        System.out.println("Minimum Subarray Length: " + minSubArrayLen(target2, nums2)); // Output: 2

        int[] nums3 = {1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println("Minimum Subarray Length: " + minSubArrayLen(target3, nums3)); // Output: 0
        
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        int target4 = 5;
        System.out.println("Minimum Subarray Length: " + minSubArrayLen(target4, nums4)); // Output: 1
	}
	
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {

            currentSum += nums[end];


            while (currentSum >= target) {
                minLength = Math.min(minLength, end - start + 1);


                currentSum -= nums[start];
                start++;
            }
        }


        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}

/*

Approach: sliding window technique.

Time Complexity:

	•	Time Complexity:  O(n) , where  n  is the length of the input array nums. This is because both pointers (start and end) move across the array at most once.

Space Complexity:

	•	Space Complexity:  O(1) , since we are only using a few extra variables to keep track of the sum and minimum length.
*/