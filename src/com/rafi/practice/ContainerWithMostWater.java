package com.rafi.practice;

public class ContainerWithMostWater {

	public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Area: " + maxArea(height)); // Expected Output: 49
	}
	
    public static int maxArea(int[] height) {
        
        if (height == null || height.length < 2) {
            return 0;
        }

        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        
        while (left < right) {
            
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;

            
            maxArea = Math.max(maxArea, area);

            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}


/*

	1.	Brute Force Approach: You could check every pair of lines and calculate the area between them. This would take O(n^2) time complexity, which is inefficient for large inputs.
	
	2.	Optimal Approach (Two-pointer technique): The optimal way to solve this is to use the two-pointer approach:
	•	Start with one pointer at the beginning (left) and one pointer at the end (right).
	•	Calculate the area between the two pointers (width * min(height[left], height[right])).
	•	Move the pointer pointing to the shorter line inward to try and find a taller line, which might give a larger area.
	•	Continue this process until the pointers meet.

Time Complexity:

	•	O(n) where n is the length of the height array because we only traverse the array once with the two pointers.

Space Complexity:

	•	O(1) since we only use a constant amount of extra space for variables (left, right, maxArea, etc.).

*/