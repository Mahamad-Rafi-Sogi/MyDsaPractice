package com.rafi.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");

        String result = findLongestWord(s, dictionary);
        System.out.println(result); // Output: "apple"
    }
    
    public static String findLongestWord(String s, List<String> dictionary) {
        // Sort the dictionary based on length (desc) and lexicographical order (asc)
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); // Descending by length
            }
            return a.compareTo(b); // Ascending lexicographically
        });
        
        System.out.println(dictionary);

        // Check each word in the sorted dictionary
        for (String word : dictionary) {
            if (canFormWord(s, word)) {
                return word;
            }
        }

        return ""; // No valid word found
    }

    // Helper function to check if `word` can be formed from `s`
    private static boolean canFormWord(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length(); // All characters of `word` are matched
    }
}

/*
Approach

Steps:

	1.	Sort the dictionary:
	•	First by length in descending order.
	•	Then lexicographically in ascending order for strings of the same length.
	2.	Check if a word in the dictionary can be formed from s using a helper function.
	3.	Return the first word that satisfies the condition.


Time Complexity

	1.	Sorting the Dictionary:
	•	O(n \log n), where n is the size of the dictionary.
	2.	Matching Each Word:
	•	For each word in the dictionary, the matching takes O(s + w), where s is the length of s and w is the length of the word.
	•	Total: O(n \cdot m), where m is the average length of the words in the dictionary.

Space Complexity

	•	O(1): No additional data structures are used apart from the input.
*/