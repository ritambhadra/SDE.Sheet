import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head == null||head.next == null||k == 0) return head;
        Node temp = head;
        int length = 1;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        //link last node to first node
        temp.next = head;
        k = k%length; //when k is more than length of list
        length -= k; //to get end of the list
        while(length-- != 0) 
            temp = temp.next;
        //breaking last node link and pointing to NULL
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}
