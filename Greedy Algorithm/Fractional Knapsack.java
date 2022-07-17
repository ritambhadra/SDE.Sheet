import java.util.*;
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair{
            int weight;
            int value;
            Pair(int weight, int value){
                this.weight = weight;
                this.value = value;
           }
        }
        
*****************************************************************/
class itemComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b){
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 > r2) return -1;
        else return 0;
    }
}

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
            // Write your code here.
            // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, new itemComparator());
        int currWeight = 0;
        double finalValue = 0.0;
        for(int i = 0 ; i < n ; i++){
            if(currWeight + items[i].weight <= w){
                currWeight += items[i].weight;
                finalValue += items[i].value;
            } else {
                int remainWeight = w - currWeight;
                finalValue += ((double)items[i].value / (double)items[i].weight) * (double)remainWeight;
                break;
            }
        }
        return finalValue;
    }
}

