import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
		// Write your code here.
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        LinkedListNode ans;
        boolean l1_isSmaller = (l1.data < l2.data);
        if(l1_isSmaller){
            ans = l1;
            ans.next = sortTwoLists(l1.next, l2);
        } else {
            ans = l2;
            ans.next = sortTwoLists(l1, l2.next);
        }
        return ans;
    }
}


