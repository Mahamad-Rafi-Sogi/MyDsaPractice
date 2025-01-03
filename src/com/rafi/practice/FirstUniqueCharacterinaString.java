package com.rafi.practice;

import java.util.HashMap;

public class FirstUniqueCharacterinaString {

	public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Input: " + s1 + " -> Output: " + firstUniqChar(s1)); // Output: 0
        System.out.println("Input: " + s2 + " -> Output: " + firstUniqChar(s2)); // Output: 2
        System.out.println("Input: " + s3 + " -> Output: " + firstUniqChar(s3)); // Output: -1

	}
	
    public static int firstUniqChar(String s) {
 
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i; 
            }
        }
        
        return -1; 
    }

}
/*
 //Approach: HashMap-Based Solution
 	•	Time Complexity:
	•	Counting character frequencies: O(n), where n is the length of the string.
	•	Finding the first unique character: O(n). 
		Overall: O(n).
		
	•	Space Complexity:
	•	Using a HashMap to store character frequencies: O(1), since there are at most 26 lowercase letters.
 */
