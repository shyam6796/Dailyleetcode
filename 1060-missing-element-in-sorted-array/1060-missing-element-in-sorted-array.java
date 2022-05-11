class Solution {
    public int missingElement(int[] nums, int k) {
        int left=0, right = nums.length-1, ref = nums[0]; // store the first element to make 
		//first element-based answer like we have 0-based or 1-based array
        while(left <= right) {
            int mid = left + (right - left)/2;
			//get the array element and subtract the reference and mid index - which 
			//shows how many element are mising before array element
            if(nums[mid] - (mid + ref) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + k + ref;
    }

}