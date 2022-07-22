
import java.util.* ;
import java.io.*; 


public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      // Write your code here.
      
      if(arr == null || arr.length == 0)
          return "No";
      
      Arrays.sort(arr);
      
      for(int i=0;i<n;i++){
          for(int j=i+1;j<n;j++){
              long target_2 = (long)target - (long)arr[i] - (long)arr[j];
              
              int left = j+1;
              int right = n-1;
              
              while(left < right){
                  long two_sum = (long)arr[left] + (long)arr[right];
                  if(two_sum < target_2)    left++;
                  else if(two_sum > target_2)    right--;
                  else{
                      ArrayList<Integer> quad = new ArrayList<>();
                      
                      quad.add(arr[i]);
                      quad.add(arr[j]);
                      quad.add(arr[left]);
                      quad.add(arr[right]);
                      
                      return "Yes";
                  }                
              }              
              while(j+1 < n && arr[j+1]== arr[j])    j++;
          }
          while(i+1 < n && arr[i+1] == arr[i])    i++;        
      }
      return "No";
  }
}
