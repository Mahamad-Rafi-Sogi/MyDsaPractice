package com.rafi.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
	public static void main(String[] args) {
		String input = "abcbcdefgdcds";
		String output = getLongestSubString(input);
		System.out.println(output);
	}

	public static String getLongestSubString(String s) {

		Set<Character> set = new HashSet<>();
		int maxLength = 0, left = 0, start = 0;

		for (int right = 0; right < s.length(); right++) {

			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));

			if (right - left + 1 > maxLength) {
				maxLength = right - left + 1;
				start = left;
			}

		}
		return s.substring(start, start + maxLength);
	}
}