import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*****************************************************************/

public class Solution {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        // Write your code here!
        if(head == null || head.next == null) return true;
        
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        // Finding the middle of Linkedlist
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the right half
        slow.next = reverseList(slow.next);
        
        // move slow to right half
        LinkedListNode rightHalf = slow.next;
        LinkedListNode leftHalf = head;
        
        // check for left half and right half eual or not
        while(rightHalf != null){
            if(! rightHalf.data.equals(leftHalf.data))
                return false;
            leftHalf = leftHalf.next;
            rightHalf = rightHalf.next;
        }
        return true;
    }
    
    private static LinkedListNode reverseList(LinkedListNode<Integer> head){
        LinkedListNode pre = null ;
        LinkedListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
