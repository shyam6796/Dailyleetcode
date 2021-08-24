class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)return false;
        TreeMap<Integer,Integer>map =new TreeMap<>();
        for(int i : hand){
           if(!map.containsKey(i)){
               map.put(i,1);
           }else{
               map.replace(i,map.get(i)+1);
           }
        }
        
        while(map.size() > 0){
            int min_val = map.firstKey();
            for(int i = min_val; i< min_val + groupSize; i++){
                if(!map.containsKey(i))return false;
                int count =map.get(i);
                if(count == 1)map.remove(i);
                else map.replace(i,count-1);
            }
        }
        return true;
    }
}