package com.rafi.practice;


class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class AddTwoNumbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args) {
	    AddTwoNumbers solution = new AddTwoNumbers();

	    // Create first list: 2 -> 4 -> 3
	    ListNode l1 = new ListNode(2);
	    l1.next = new ListNode(4);
	    l1.next.next = new ListNode(3);

	    // Create second list: 5 -> 6 -> 4
	    ListNode l2 = new ListNode(5);
	    l2.next = new ListNode(6);
	    l2.next.next = new ListNode(4);

	    // Add two numbers
	    ListNode result = solution.addTwoNumbers(l1, l2);

	    // Print result
	    while (result != null) {
	        System.out.print(result.val + " ");
	        result = result.next;
	    }
	}
}

/*


	•	Time Complexity: O(\max(m, n)), where m and n are the lengths of the two lists.
	•	Space Complexity: O(\max(m, n)), for the resulting linked list.
 */
