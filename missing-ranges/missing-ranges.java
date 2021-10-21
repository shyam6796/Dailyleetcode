class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        TreeSet<Integer>  set = new TreeSet<>();
        List<String> list = new ArrayList<>();
        
        if(nums.length==0){
            if(lower==upper){
                list.add(lower+"");
            }
            else{
                list.add(lower+"->"+upper);
            }
            return list;
        }
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        
         if(nums[0]!=lower){
            if(lower+1==nums[0]) list.add(lower+"");
            else list.add(lower+"->"+(nums[0]-1));
             lower =nums[0];
        }
       
        
        for(int i=lower; i<=upper; i++){
            if(set.contains(i)){
                continue;
            }
            String temp=null;
            Integer low =set.floor(i);
            Integer high =set.ceiling(i);
            if(high !=null &&  low !=null &&high -low ==2){
                low++;
                temp=low+"";
            }else if(high !=null &&  low !=null){
                low++;
                high--;
                temp = low +"->"+high;
            }else if(low !=null && high ==null){
                low++;
                if(low==upper){
                    list.add(upper+"");
                }else{
                   list.add(low+"->"+upper); 
                }
                break;
            }
            list.add(temp);
            i=set.ceiling(i);
       
        }
        return list;
    }
}