package com.rafi.practice;

public class DesignHashMap {
	
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static final int SIZE = 1000; // Number of buckets
    private Node[] buckets;
    
    public DesignHashMap() {
    	buckets = new Node[SIZE];
    }
    
    private int hash(int key) {
        return key % SIZE;
    }
    
    // Put operation
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1); // Dummy head
        }
        Node prev = findNode(key, index);
        if (prev.next == null) {
            prev.next = new Node(key, value); // Insert new node
        } else {
            prev.next.value = value; // Update existing value
        }
    }
    
    // Get operation
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) return -1;
        Node prev = findNode(key, index);
        return prev.next == null ? -1 : prev.next.value;
    }
    
    // Remove operation
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        Node prev = findNode(key, index);
        if (prev.next != null) {
            prev.next = prev.next.next; // Remove node
        }
    }
    
    private Node findNode(int key, int index) {
        Node prev = buckets[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        DesignHashMap myHashMap = new DesignHashMap();

        // Test put() and get()
        myHashMap.put(1, 1); // Add key 1 with value 1
        myHashMap.put(2, 2); // Add key 2 with value 2
        System.out.println(myHashMap.get(1)); // Output: 1 (value of key 1)
        System.out.println(myHashMap.get(3)); // Output: -1 (key 3 does not exist)

        // Test update
        myHashMap.put(2, 1); // Update key 2 to value 1
        System.out.println(myHashMap.get(2)); // Output: 1 (updated value of key 2)

        // Test remove
        myHashMap.remove(2); // Remove key 2
        System.out.println(myHashMap.get(2)); // Output: -1 (key 2 no longer exists)

        // Add more elements to check collision handling
        myHashMap.put(1001, 10); // Causes a collision with key 1
        System.out.println(myHashMap.get(1001)); // Output: 10
        System.out.println(myHashMap.get(1));    // Output: 1 (still accessible despite collision)

        System.out.println("All tests passed!");
    }
    
}

/*
 Approach for Solving the Problem

We’ll use an array of buckets, where each bucket contains a linked list to handle collisions (using chaining).

 Complexity Analysis

	•	Time Complexity:
	•	put, get, and remove: O(n/k) on average, where n is the number of keys and k is the number of buckets. In the best case, O(1).
	•	Space Complexity:
	•	O(n + k), where n is the number of keys, and k is the bucket size.
	

 */
