import java.util.ArrayList;

public class Solution {
    public static int uniqueElement(ArrayList<Integer> arr) {
        //    Write your code here.
        int s = 0 ;
        int e = arr.size() - 2;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(arr.get(mid) == arr.get(mid^1))
                s = mid +1;
            else 
                e = mid -1;
        }
        return arr.get(s);
    }
}
