class Solution {
    Map<Integer,Integer> map;
    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        int [] uniqueNums =new int[map.size()];
        int index =0;
        for(int i : map.keySet()){
            uniqueNums[index++] =i;
        }

        return quickSelect(uniqueNums,k);
    }
    public int[] quickSelect(int nums[], int k){
        int left =0;
        int right = nums.length-1;
        int pivot = nums.length;

        while(pivot !=k){
            pivot = partation(nums,left,right);
            if(pivot >k){
                right =pivot-1;
            }else{
                left =pivot+1;
            }
        }
        return Arrays.copyOf(nums, k);
    }
    public int partation(int nums[], int left, int right){
        int pivotIndex =left +(right -left)/2;
        int pivot =nums[pivotIndex];
        int pivotFreq = map.get(pivot);
        swap(nums,pivot,right);
        int index =left;

        for(int i =left; i <right; i++){
            if(map.get(nums[i]) >= pivotFreq){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,index,right);
        return index;
    }
    public void swap(int nums[], int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] =temp;
    }
}