package com.rafi.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class possiblePermutations {

	public static Map<Character, String> map = Map.of('1', "abc", '2', "def", '3', "ghi", '4', "klmn", '5', "op", '6',
			"qrs", '7', "tuv", '8', "wx", '9', "yz");

	public static void main(String[] args) {
		String input = "1238";
		List<String> output = getCombination(input);

		// Print the output
		for (String combination : output) {
			System.out.println(combination);
		}
	}

	private static List<String> getCombination(String input) {
		List<String> result = new ArrayList<>();

		if (input == null || input.isEmpty())
			return result;

		backtrack(input, 0, new StringBuilder(), result);
		return result;
	}

	private static void backtrack(String input, int index, StringBuilder s, List<String> result) {
		if (index == input.length()) {
			result.add(s.toString());
			return;
		}

		String letters = map.get(input.charAt(index));

		// Null check to avoid NullPointerException
		if (letters == null)
			return;

		for (char letter : letters.toCharArray()) {
			s.append(letter);
			backtrack(input, index + 1, s, result);
			s.deleteCharAt(s.length() - 1);
		}
	}
}