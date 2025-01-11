package com.rafi.practice;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverselinkedList {
	private static Node head;

	public static void main(String[] args) {

	        head = new Node(1);
	        head.next = new Node(2);
	        head.next.next = new Node(3);
	        head.next.next.next = new Node(4);

	        System.out.println("Original List:");
	        printList(head);

//	        head = reverse(head);
//	        System.out.println();
//	        System.out.println("Reversed List:");
//	        printList(head);
	        
	        insertAtEnd(5);
	        System.out.println("New List after insertion:");
	        printList(head);
	        
	}

	public static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		
		while(current != null) {
			Node next = current.next;
			current.next = prev; 
			prev = current; 
			current = next;
			
		}
	
		return prev;
	}

	public static void printList(Node head) {
		while(head != null) {
		System.out.print(head.data + " -> ");
		head = head.next;
		}
		System.out.println();
	}
	
	public static void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if(head == null)
			head = newNode;
		else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}
	
    public static void update(int oldValue, int newValue) {
        Node current = head;
        while (current != null) {
            if (current.data == oldValue) {
                current.data = newValue;
                System.out.println("Updated: " + oldValue + " -> " + newValue);
                return;
            }
            current = current.next;
        }
        System.out.println("Value not found: " + oldValue);
    }
	
    public static void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        // If the head node itself holds the data
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted: " + data);
            return;
        }

        // Traverse the list to find the node to delete
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found: " + data);
        } else {
            current.next = current.next.next;
            System.out.println("Deleted: " + data);
        }
    }
	
	
}