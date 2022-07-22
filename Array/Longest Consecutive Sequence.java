/*
    Time Complexity: O(N*logn(N))
    Space Complexity: O(1)

    Where N is the length of array.
*/

import java.util.Arrays;

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        // Sort the given array in ascending order.
        Arrays.sort(arr);

        // To store length of longest consecutive sequence.
        int mx = 0;

        // To store the length of current consecutive Sequence.
        int count = 0;

        for (int i = 0; i < N; i++) {

            // Check if previous value is consecutive to the current value.
            if (i > 0 && (arr[i] == arr[i - 1] + 1)) {
                count++;

            }
            // Skip if the current value is equals to the previous value.
            else if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            // Reseting count for next upcoming consecutive sequence.
            else {
                count = 1;
            }

            mx = Math.max(mx, count);
            
        }

        return mx;
    }
}



// My Solution
import java.util.* ;
import java.io.*; 

public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] nums, int N) {
        // Write your code here.
        
        Set<Integer> hs = new HashSet<>();
        for(int num: nums)
            hs.add(num);
        
        int longestStreak = 0;
        for (int num: nums) {
            if (!hs.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hs.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
