package com.rafi.practice;

import java.util.*;
class permutation {
    public static void main(String[] args) {
        String input = "abc";
        
        List<String> permutations = findAllpermutaions(input);
        
        System.out.println("permutation of input : " + input + ":");
        
        for(String perm: permutations) 
            System.out.println(perm);
    }
    
    public static List<String> findAllpermutaions(String str){
        List<String> result = new ArrayList<>();
        backtrack(str.toCharArray(), 0, result);
        return result;
    }
    
    public static void backtrack(char[] chars, int index, List<String> result){
        if(index == chars.length){
            result.add(new String(chars));
            return;
        }
        for (int i = index ; i < chars.length ; i++){
            swap(chars,index,i);
            backtrack(chars,index+1,result);
            swap(chars, index, i);
        }
    }
    
    public static void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    
}