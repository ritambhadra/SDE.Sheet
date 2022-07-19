import java.util.* ;
import java.io.*; 

public class Solution{
   public static void sort012(int[] arr){
       int start = 0 ; 
       int mid = 0; 
       int end = arr.length  - 1;
       
       while(mid <= end){
           if(arr[mid] == 0){
               int temp = arr[start];
               arr[start] = arr[mid];
               arr[mid] = temp;
               mid++ ;  
               start++;
           }
           else if(arr[mid] == 1)
               mid++;
           else{
               int temp2 = arr[mid];
               arr[mid] = arr[end];
               arr[end] = temp2;
               end--;

           }
       }
    }
}
