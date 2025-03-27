package com.rafi.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		
		list.stream()
		.filter(n -> n%2 == 0)
		.forEach(n -> System.out.print(n+" "));
		
		System.out.println();
		
		list.stream()
		.map(n -> n*n)
		.forEach(n -> System.out.print(n+" "));
		
		System.out.println();
		
		int sum = list.stream().reduce(0, (a, b) -> a + b );
		System.out.println(sum);
		
		//--------------------------------------------
		
		int max = list.stream()
						.max(Comparator.naturalOrder())
						.orElseThrow(() -> new IllegalArgumentException("Empty list"));
		System.out.println(max);
		
		int min = list.stream()
				.min(Comparator.naturalOrder())
				.orElseThrow(() -> new IllegalArgumentException("Empty list"));
		System.out.println(min);
		
		//--------------------------------------------
		
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cherry", "date"),
                Arrays.asList("elderberry", "fig")
            );

            // Flatten the list of lists
            List<String> flattened = listOfLists.stream()
                                                .flatMap(Collection::stream)
                                                .collect(Collectors.toList());

            System.out.println(flattened);
            
        //--------------------------------------------
            
            List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David", "Eve", "Adam");

            // Group names by their first letter
            Map<Character, List<String>> groupedByFirstLetter = names.stream()
                                                                      .collect(Collectors.groupingBy(name -> name.charAt(0)));

            System.out.println(groupedByFirstLetter);
            
          //--------------------------------------------
            
		
	}
}
