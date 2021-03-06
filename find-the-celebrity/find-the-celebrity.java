/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cann=0;
        for(int i=1; i<n; i++){
            if(knows(cann,i)){
                cann=i;
            }
        }
        
        for(int i=0; i<n; i++){
            if(i==cann)continue;
            else if(!knows(i,cann) || knows(cann,i)){
                return -1;
            }
        }
        return cann;
    }
}