//  CodeStudio Sol

import java.util.*;

class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<meeting>{
    public int compare(meeting m1, meeting m2){
        if(m1.end < m2.end) return -1;
        else if(m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        return 1;
    }
}

public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        //Write your code here
        ArrayList<meeting> meet = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < start.length ; i++)
            meet.add(new meeting(start[i], end[i], i+1));
            
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for(int i = 0 ; i < start.length ; i++){
            if(meet.get(i).start > limit){
                ans.add(meet.get(i).pos);
                limit = meet.get(i).end;
            }
        }
            return ans;
    }
}

// GFG sol

class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting m1, meeting m2){
        if(m1.end < m2.end) return -1;
        else if(m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        return 1;
    }
}
class Solution {
    public static int maxMeetings(int start[], int end[], int n){
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0 ; i < start.length ; i++)
            meet.add(new meeting(start[i], end[i], i+1));
            
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        int limit = meet.get(0).end;
        int res = 1;
        for(int i = 0 ; i < start.length ; i++){
            if(meet.get(i).start > limit){
                limit = meet.get(i).end;
                res++;
            }
        }

        return res;
    }
}

// GFG sol 2

class Meetings{
   int start;
   int end;
   Meetings(int start,int end){
       this.start = start;
       this.end = end;
   }
}
class scheduleMeetings implements Comparator<Meetings>{
   
   @Override
   public int compare(Meetings a1,Meetings a2){
       return a1.end-a2.end;
   }
}
class Solution {
   public static int maxMeetings(int start[], int end[], int n){
       Meetings meetings[] = new Meetings[n];
       
       for(int i=0;i<n;i++)
           meetings[i] = new Meetings(start[i],end[i]);
           
       Arrays.sort(meetings,new scheduleMeetings());
       
       int res = 1;
       int prev = meetings[0].end;
       
       for(int i=1;i<n;i++){
           if(meetings[i].start>prev){
               res++;
               prev = meetings[i].end;
           }
       }
       return res;
   }
}












