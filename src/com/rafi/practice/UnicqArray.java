package com.rafi.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class UnicqArray {

	public static void main(String[] args) {
		int[] num = { 1, 1 , 2};
		
		unicqArrayProcessor(num);

	}

	private static void unicqArrayProcessor(int[] num) {
		Set<Integer> uniqueSet = new LinkedHashSet<>();
		Set<Integer> duplicateSet = new HashSet<>();
		
		Integer[] processedArray = new Integer[num.length];
		
		for(int i = 0; i< num.length; i++) {
			if(!uniqueSet.contains(num[i]) && !duplicateSet.contains(num[i])) {
				uniqueSet.add(num[i]);
				processedArray[i] = num[i];
			} else {
				duplicateSet.add(num[i]);
				processedArray[i] = null;
			}
		}
		System.out.println("total unique count: " + uniqueSet.size());
		System.out.println("processedArray: " + Arrays.toString(processedArray));
	}

}