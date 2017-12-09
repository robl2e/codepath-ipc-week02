/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    int carryOver = 0;
	    ListNode dummy = new ListNode(0); //reference to sum head
	    ListNode cur = dummy; // sum ptr
	    
	    ListNode aPtr = a;
	    ListNode bPtr = b;
	    
	    // 9 9 1
	    // 1
	    while (aPtr != null || bPtr != null) {
	        int aVal = aPtr != null ? aPtr.val : 0;
	        int bVal = bPtr != null ? bPtr.val : 0;
	        
	        int sum = aVal + bVal + carryOver; // 9 + 1 + 0
	        
	        int remain = sum;
	        if (sum > 9) {
	            remain = sum % 10;   
	        }
	        carryOver = (sum > 9) ? 1 : 0; // 1
	        
	        ListNode sumNode = new ListNode(remain);
	        cur.next = sumNode;
	        cur = cur.next;
	        
	        // If possible move ptr
	        if (aPtr != null) {
	            aPtr = aPtr.next;
	        }
	        
	        // If possible move ptr
	        if (bPtr != null) {
	            bPtr = bPtr.next;	            
	        }
	    }
	    
	    // If carry over leftover add
	    // node
	    if (carryOver > 0) {
    	        ListNode sumNode = new ListNode(carryOver);
    	        cur.next = sumNode;
	    }
	    return dummy.next; // 1st Node is dummy node, so want next
	}
}
