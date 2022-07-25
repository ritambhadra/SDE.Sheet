public class Solution {
    public static int search(int arr[], int key) {
        // Write your code here.
        int s  = 0 ; 
        int e  = arr.length - 1 ;
        int mid = 0 ;
        while(s <= e){
            mid = s + (e - s)/2;
            if(arr[mid] == key) return mid;
            
            if(arr[s] <= arr[mid]){
            
                if(arr[s]<= key && key <= arr[mid]) e = mid - 1;
                else s = mid + 1;
                
            } else {
            
                if(arr[mid]<= key && key <= arr[e]) s = mid + 1;
                else e = mid - 1;
            }
        }
        return -1;
    }
}
