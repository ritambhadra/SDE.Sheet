import java.util.* ;
import java.io.*; 

/*
    Following is the structure of the Singly Linked List.
    
    class LinkedListNode<T>{
        T data;
        LinkedListNode<T> next;
        public LinkedListNode(T data){
            this.data = data;
        }
    }
*/

public class Solution{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head){
        // Write your code here!
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        
        while(curr != null){
            LinkedListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev; 
    }
}
