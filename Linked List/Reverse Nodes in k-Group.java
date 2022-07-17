import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
    public static Node getListAfterReverseOperation(Node head, int n, int arr[]) {
        // Write your code here.
        return reverse(head, 0, arr);
    }
    public static Node reverse(Node head, int index, int[] arr) {
        if(head == null) return null;
        if(index == arr.length) return head;
        if(arr[index] == 0) return reverse(head, index+1, arr);
        Node next = null;
        Node curr = head;
        Node prev = null;
        int count = 0;
        
        while(curr != null && count < arr[index]) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
            count++;
        }
        head.next = reverse(curr, index+1, arr);
        
        return prev;
    }
}
