/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SolutionSwapListNodePairs {
	public ListNode swapPairs(ListNode a) {
	    if (a == null) return a;
	    if (a.next == null) return a;
	    
	    ListNode head = null;
	    ListNode slow = a;
	    ListNode fast = a.next;
	    
	    while (fast != null && slow != null) {
	        swap(slow, fast);
	        
	        if (head == null) {
	            head = slow;
	        }
	        
	        // slow is where fast is
	        // fast is one ahead of fast
	        slow = fast;
	        fast = fast.next; 

	        
	        // Move pointers
	        slow = slow.next;
	        if (fast != null) {
	            fast = fast.next;
	        }
	    }
	    
	    return head;
	}
	
	public void swap(ListNode a, ListNode b) {
	    // a->b->c
	    int tmp = a.val;
	    a.val = b.val;
	    b.val = tmp;
	}
}
