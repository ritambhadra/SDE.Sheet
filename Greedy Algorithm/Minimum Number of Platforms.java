import java.util.Arrays;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        // Write your code here.
        Arrays.sort(at);
        Arrays.sort(dt);
        
        int i = 1; 
        int j = 0;
        int minNumOfPlatforms = 1;
        int platformReq = 1;
         while (i < n && j < n) { 
            if (at[i] <= dt[j]) { 
                platformReq++; 
                i++; 
            } else if (at[i] > dt[j]) { 
                platformReq--; 
                j++; 
            } 
             minNumOfPlatforms = Math.max(minNumOfPlatforms, platformReq);
        } 
        return minNumOfPlatforms; 
    }
}
