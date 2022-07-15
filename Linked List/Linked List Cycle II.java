import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
		{
		    public int data;
		    public Node next;

		    Node(int data)
		    {
		        this.data = data;
		        this.next = null;
		    }
		}

*****************************************************************/

public class Solution {
    public static Node firstNode(Node head){
        if(head == null || head.next == null) return null;
        Node slow = head, fast = head, ans = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                while(slow != ans){
                    ans = ans.next ;
                    slow = slow.next ;                    
                }
                return ans;
            }
        }
        return null;
    }
}
