package com.rafi.practice;



class Main {
    public static void main(String[] args) {
    	System.out.println("Rafi");
    	int[] arr = {0,1,1,2,0,0,2,2};
    	
    	sortColors(arr);
    	
        for (int num : arr) 
            System.out.print(num + " ");
    }

	private static void sortColors(int[] arr) {
    	int low =0, high = arr.length-1, mid=0;
    	
    	while(mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                // Swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
    		
    	}
	}
}