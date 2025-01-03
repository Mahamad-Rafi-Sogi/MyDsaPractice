package com.rafi.practice;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median: " + findMedianSortedArrays(nums3, nums4)); // Output: 2.5
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

 
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1]; //Integer.MIN_VALUE
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1]; //1
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1]; //4
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2]; //Integer.MIN_VALUE

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
              
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
               
                high = partition1 - 1;
            } else {
        
                low = partition1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

}

/*
 approach: Binary Search
 
 Time Complexity

The time complexity of the solution is  O(\log(\min(m, n))) , where:
	•	 m  is the size of the smaller array ( nums1 ).
	•	 n  is the size of the larger array ( nums2 ).
	
	Reason:
	•	The algorithm uses binary search on the smaller array, which takes  O(\log(m))  time.
	•	At each step, the search space is halved until the correct partition is found.
	
Space Complexity

The space complexity is  O(1) .

Reason:
	•	No additional data structures are used; only a few integer variables are allocated for calculations (e.g., low, high, partition1, partition2, etc.).
	•	All operations are performed in-place.
 */


/*
we can go with just merging two arrays and then sorting that array then returning middle element this is higher time complexity

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Merge the two arrays
        int[] mergedArray = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }

        // Sort the merged array
        Arrays.sort(mergedArray);

        // Find the median
        int length = mergedArray.length;
        if (length % 2 == 0) {
            return (mergedArray[length / 2 - 1] + mergedArray[length / 2]) / 2.0;
        } else {
            return mergedArray[length / 2];
        }
    }

*/