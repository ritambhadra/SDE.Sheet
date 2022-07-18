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
        else if( m1.end > m2.end) return 1;
        else if(m1.pos < m2.pos) return -1;
        
        return 1;
    }
}

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0 ; i < start.size() ; i++)
            meet.add(new meeting(start.get(i), end.get(i), i));
            
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        int ans = 1;
        int limit = meet.get(0).end;
        for(int i = 1 ; i < meet.size() ; i++){
            if(meet.get(i).start >= limit){
                limit = meet.get(i).end;
                ans++;
            }
        }
            return ans;
        
    }
}


