import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
    public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K{

        LinkedListNode<Integer> temp = head;
        int count = 0 ; 
        if(temp == null) return head;
        if(K == 0) return head;
        
        while(temp != null){
            count++;
            temp = temp.next;
        }
     
        if((count - K) == 0){
            head = head.next;
            return head;
        }
        
        temp = head;
        for(int i = 0 ; i < (count - K) -1 ; i++)
            temp = temp.next;
     
        temp.next = temp.next.next;
        
        return head;
    }
}

