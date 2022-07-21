import java.util.* ;
import java.io.*;

/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        Arrays.sort(intervals , (a , b) -> a.start - b.start);
        List<Interval> mergedInvervals = new ArrayList<>();
        int newStart = intervals[0].start;
        int maxFinish = intervals[0].finish;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start <= maxFinish)
                maxFinish = Math.max(maxFinish, intervals[i].finish);    
            else{
                mergedInvervals.add(new Interval(newStart, maxFinish));
                newStart =  intervals[i].start;
                maxFinish = intervals[i].finish;
            }
        }
        
        mergedInvervals.add(new Interval(newStart, maxFinish));
        return mergedInvervals;
    }
}


