import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

 

public class Solution{
   public static int findDuplicate(ArrayList<Integer> arr, int n){

         int a[] = new int[n];
         int ans = 0;
         for(int i = 0 ; i < arr.size() ; i++){
             ans = arr.get(i);
             if(a[ans] >=1)
                break;
             a[ans] = a[ans] + 1;
         }
         return ans;
   }

}

