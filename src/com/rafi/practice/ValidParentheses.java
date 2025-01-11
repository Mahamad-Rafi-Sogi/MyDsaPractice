package com.rafi.practice;	
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "'(',')','{','}','[',']'";

        boolean isValid = isValidParentheses(input);
        System.out.println(isValid);
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        
        for (char c : s.toCharArray()) {
          
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 

            else if (c == ')' || c == '}' || c == ']') {
                
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
                    return false;
                }
                stack.pop(); 
            }
        }

       
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}