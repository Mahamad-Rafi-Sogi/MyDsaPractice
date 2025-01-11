package com.rafi.practice;

public class SubsequenceCheck {
	public static void main(String[] args) {
	
	String s1 = "";
	String s2 = "";
	boolean isSubsequence = isSubsequence(s1,s2);
	System.out.println(isSubsequence);
	
	}

	private static boolean isSubsequence(String s1, String s2) {	
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++; 
            }
            i++; 
        }
		return j==s2.length();
	}

}
