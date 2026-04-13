class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums)list.add(i);
        int count =0;
        
        while(!is_sorted(list)){
            int index = helepr(list);
            int val = list.get(index) +list.get(index+1);
            list.set(index,val);
            list.remove(index+1);
            count++;
        }
        return count;
    }

    public boolean is_sorted(List<Integer> list){
        for(int i =1; i < list.size(); i++){
            if(list.get(i) < list.get(i-1))return false;
        }
        return true;
    }
    public int helepr(List<Integer> list){
         int minsum =Integer.MAX_VALUE;
        int index =-1;
        for(int i=0; i <list.size()-1;i++){
            if(list.get(i) +list.get(i+1) < minsum){
                minsum =list.get(i)+list.get(i+1);
                index=i;
            }
        }
        return index;
    }

}