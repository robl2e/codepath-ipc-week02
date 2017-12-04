/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SolutionDeleteDuplicates {
	public ListNode deleteDuplicates(ListNode a) {
	    if (a == null) return a;
	    if (a.next == null) return a;
	    
	    ListNode cur = a;
	    ListNode prev = a;
	    
	    cur = cur.next; // one past start
	    while (cur != null) {
	        if (prev.val == cur.val) {
	            prev.next = cur.next; // unlink cur
	        } else {
	            prev = cur; // new prev
	        }
	        cur = cur.next; // move pointer
	    }
	    
	    return a;
	}
}