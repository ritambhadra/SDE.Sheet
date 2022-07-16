import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
        LinkedListNode iter = head; 
        LinkedListNode front = head;

          // First round: make copy of each node,
          // and link them together side-by-side in a single list.
          while (iter != null) {
            front = iter.next;
            LinkedListNode copy = new LinkedListNode(iter.data);
            iter.next = copy;
            copy.next = front;
            iter = front;
          }

          // Second round: assign random pointers for the copy nodes.
          iter = head;
          while (iter != null) {
            if (iter.random != null)
              iter.next.random = iter.random.next;
            
            iter = iter.next.next;
          }

          // Third round: restore the original list, and extract the copy list.
          iter = head;
          LinkedListNode pseudoHead = new LinkedListNode(0);
          LinkedListNode copy = pseudoHead;

          while (iter != null) {
            front = iter.next.next;

            // extract the copy
            copy.next = iter.next;
            copy = copy.next;

            // restore the original list
            iter.next = front;

            iter = front;
          }
          return pseudoHead.next;
	}
}

