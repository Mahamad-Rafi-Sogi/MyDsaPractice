package com.rafi.practice;

import java.util.*;

public class MinHeap {
    // Function to heapify a subtree rooted at index i
    static void heapify(int arr[], int n, int i) {
        int smallest = i;     // Initialize smallest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is smaller than root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If right child is smaller than smallest so far
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If smallest is not root
        if (smallest != i) {
            // Swap root with smallest
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, smallest);
        }
    }

    // Function to build the heap
    static void buildHeap(int arr[], int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal from last non-leaf node
        // and heapify each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Function to print array representation of Heap
    static void printHeap(int arr[], int n) {
        System.out.println("Heap:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 4, 10, 3, 5, 1 };
        int n = arr.length;

        buildHeap(arr, n);
        printHeap(arr, n);
    }
}