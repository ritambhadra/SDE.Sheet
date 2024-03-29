import java.util.*;
public class Solution{
    
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
        // Write your code here.
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum=a.get(i)+b.get(j);
                if(pq.size()<k)pq.add(sum);
                else if(sum>pq.peek()){
                    pq.poll();
                    pq.add(sum);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll());
        }
        
        return ans;
    }
}
