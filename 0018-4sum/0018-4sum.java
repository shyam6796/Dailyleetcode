class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-3; i++){
            if(i >0 && nums[i] ==nums[i-1])continue;
            for(int j =i+1; j < nums.length-2; j++){
                if( j >i+1 && nums[j] ==nums[j-1])continue;

                int k = j+1;
                int l = nums.length-1;
                while(k < l){
                    long sum =(long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        tempList.add(nums[l]);
                        list.add(tempList);
                        while(k <l && nums[k]==nums[k+1])k++;
                        while(k <l && nums[l]==nums[l-1])l--;
                        k++;
                        l--;
                    }else if(sum > target) l--;
                    else k++;
                }
            }
        }
        return list;
    }
}