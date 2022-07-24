import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
        // Write your code here.
        int row = 0;
        int col = n-1;
        
        while(row < m && col >= 0){
            if(mat.get(row).get(col) == target) return true;
            else if(mat.get(row).get(col) > target) col --;
            else row ++;
        }
        return false;
    }
}


