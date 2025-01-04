package com.rafi.practice;

import java.util.HashMap;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
        int numerator1 = 1, denominator1 = 2;
        System.out.println(fractionToDecimal(numerator1, denominator1)); // Output: "0.5"

        int numerator2 = 2, denominator2 = 3;
        System.out.println(fractionToDecimal(numerator2, denominator2)); // Output: "0.(6)"

        int numerator3 = 4, denominator3 = 333;
        System.out.println(fractionToDecimal(numerator3, denominator3)); // Output: "0.(012)"

        int numerator4 = 1, denominator4 = 5;
        System.out.println(fractionToDecimal(numerator4, denominator4)); // Output: "0.2"
	}
	
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0"; // Edge case: numerator is 0

        StringBuilder result = new StringBuilder();

        // Determine the sign
        if (numerator < 0 ^ denominator < 0) result.append("-");

        // Convert numerator and denominator to positive long to handle overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part
        result.append(num / den);
        num %= den; // Get the remainder

        if (num == 0) return result.toString(); // No fractional part

        // Append the decimal point
        result.append(".");

        // Use a HashMap to store remainders and their positions
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (num != 0) {
            if (remainderMap.containsKey(num)) {
                // Repeating part found
                result.insert(remainderMap.get(num), "(");
                result.append(")");
                break;
            }

            // Store the current remainder and its position in the result
            remainderMap.put(num, result.length());


            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }

}

/*

Approach:

To solve this problem, follow these steps:
	1.	Handle Edge Cases:
	•	If numerator is 0, return “0”.
	•	Determine the sign of the result based on the signs of the numerator and denominator.
	2.	Handle the Integer Part:
	•	Compute the integer part of the fraction using integer division (numerator / denominator).
	3.	Handle the Fractional Part:
	•	Use a remainder to compute the fractional part.
	•	Use a HashMap to track previously seen remainders and their positions in the result string.
	•	If a remainder repeats, the decimal part is repeating.
	4.	Build the Result:
	•	Append the integer part, the non-repeating part of the fractional part, and the repeating part (if any).
	
	
	1.	Time Complexity:
	•	 O(d) , where  d  is the size of the repeating part or the length of the fractional part. Each unique remainder is processed once.
	2.	Space Complexity:
	•	 O(d) , for storing remainders in the HashMap.

 */
