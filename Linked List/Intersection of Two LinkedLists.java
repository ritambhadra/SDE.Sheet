import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {
	public static int findIntersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if( head1 == null || head2 == null) return -1;
        
        LinkedListNode d1 = head1;
        LinkedListNode d2 = head2;

        while(d1 != d2) {
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }
        int ans = d1 == null ? -1 : (int)d1.data;
    
        return ans;
    }
}
