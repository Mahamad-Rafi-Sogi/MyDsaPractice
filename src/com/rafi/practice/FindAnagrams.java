package com.rafi.practice;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagrams {
    public static void main(String[] args) {
        String[] words = {"peek", "seek", "keep", "cat", "fat", "rat", "tac"};

        // Find strings with anagrams
        List<String> result = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> getSortedString(word), // Group by sorted characters
                        Collectors.toList()))
                .values().stream()
                .filter(group -> group.size() > 1) // Keep only groups with more than 1 string
                .flatMap(List::stream) // Flatten the groups into a single stream
                .collect(Collectors.toList()); // Collect as a list

        // Convert to array (if needed)
        String[] output = result.toArray(new String[0]);

        // Print the result
        System.out.println(Arrays.toString(output));
        
        List<String> list2 = Arrays.stream(words)
        							.collect(Collectors.groupingBy(
        									word -> getSortedString(word), Collectors.toList()))
        							.values().stream()
        							.filter(group -> group.size() > 1)
        							.flatMap(List::stream)
        							.collect(Collectors.toList());
        System.out.println(list2);
        
        List<String> list3 = Arrays.stream(words)
        							.map(word -> getSortedString(word))
        							.filter(word -> word.length()>3)
        							.collect(Collectors.toList());
        System.out.println(list3);
    }

    // Helper method to sort the characters of a string
    private static String getSortedString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
