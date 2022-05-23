class Solution {
    public int minIncrementForUnique(int[] nums) {
         Arrays.sort(nums);
    int count = 0;

    for (int i = 1; i < nums.length; i++) {
      int current = nums[i];
      int prev = nums[i - 1];
      if (current <= prev) {
        int add =1+ prev-current;
        count +=add;
        nums[i] +=add;
      }
    }

    return count;
    }
}