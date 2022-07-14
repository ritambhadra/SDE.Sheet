import java.util.* ;
import java.io.*; 

public class Solution {    
    public static boolean detectCycle(Node<Integer> head) {
        //Your code goes here
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
