package com.rafi.practice;

public class TrappingRainwater {

	public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Water Trapped: " + trap(height1)); // Output: 6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Water Trapped: " + trap(height2)); // Output: 9

	}
	
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0; // No bars, no water
        }

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

}

/*

Approach: Two-pointer technique:

Time Complexity:

	•	Time Complexity:  O(n) , where  n  is the number of bars (elements in the array). We only need to traverse the array once with the two-pointer technique.

Space Complexity:

	•	Space Complexity:  O(1) , since we only use a constant amount of space to store pointers, max values, and the trapped water.

 */
