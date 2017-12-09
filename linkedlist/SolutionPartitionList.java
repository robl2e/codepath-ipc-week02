/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode partition(ListNode a, int b) {
	    if (a.next == null) return a; //1 node case
	    
	    ListNode dummyLess = new ListNode(0);
	    ListNode less = dummyLess;
	    
	    ListNode dummyMore = new ListNode(0);
	    ListNode more = dummyMore;
	    
	    ListNode cur = a;
	    while (cur != null) {
	        int val = cur.val;
	        if (val >= b) {
	            // Add to more list
	            more.next = cur;
	            more = cur;
	        } else {
	            // Add to less list
	            less.next = cur;
	            less = cur;
	        }
	        cur = cur.next;
	    }
	    
	    // Last item in more list should end entire list
	    // ensure no cycle formed
	    more.next = null; 
	    
	    // Combine/Merge less list with more list
	    less.next = dummyMore.next; // one after dummy is actual list
	    ListNode ans = dummyLess.next; // one after dummy is actual list
	    return ans;
	}
}
