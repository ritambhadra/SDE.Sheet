/*
        Time Complexity: O(N ^ 2)
        Space Complexity: O(1)

        Where N is the size of the array.
*/


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int reversePairs(ArrayList<Integer> arr){
        // Write your code here.
        int res = 0 ;
        for(int i = 0 ; i < arr.size() - 1; i++){
            for(int j = i+1 ; j < arr.size() ; j++)
                if(i < j && arr.get(i) > 2 * arr.get(j))
                    res++;
        }
        return res;
    }
}


/*
    Time Complexity: O(N*(logN))
    Space Complexity: O(N)

    Where N is the size of the array.
*/

import java.util.ArrayList;

public class Solution {
    public static void merge(ArrayList<Integer> arr, int start, int mid, int end){
	    // Merging the arrays using helper arrays
	    int n1 = (mid - start + 1);
	    int n2 = (end - mid);
	    ArrayList<Integer> left = new ArrayList<>(n1); 
        ArrayList<Integer> right = new ArrayList<>(n2);

        for(int i=0 ; i<n1 ; i++)
            left.add(0);
        
        for(int i=0 ; i<n2 ; i++)
            right.add(0);
        
	    for (int i = 0; i < n1; i++)
		    left.set(i, arr.get(start + i));

	    for (int j = 0; j < n2; j++)
		    right.set(j, arr.get(mid + 1 + j));

	    int i = 0, j = 0;
	    for (int k = start; k <= end; k++) {
		    if (j >= n2 || (i < n1 && left.get(i) <= right.get(j))){
			   arr.set(k , left.get(i));
               i++;
		    } else {
			   arr.set(k , right.get(j));
               j++;
		    }
	    }
    }

    public static int mergeSort(ArrayList<Integer> arr, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;

            // Counting the pairs in the left and right arrays.
            int count = mergeSort(arr, start, mid) + mergeSort(arr, mid + 1, end);

            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && arr.get(i) > arr.get(j) * 2) 
                    j++;
                
                count += j - (mid + 1);
            }
            // Merging the arrays.
            merge(arr, start, mid, end);
            return count;
        }  else 
            return 0;
    }

    public static int reversePairs(ArrayList<Integer> arr) {
        int n = arr.size();

        return mergeSort(arr, 0, n - 1);
    }
}
