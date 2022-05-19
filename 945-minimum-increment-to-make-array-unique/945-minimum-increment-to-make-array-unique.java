class Solution {
    public int minIncrementForUnique(int[] nums) {
         Arrays.sort(nums);
    int count = 0;

    for (int i = 1; i < nums.length; i++) {
      int current = nums[i];
      int prev = nums[i - 1];
      if (current <= prev) {
        int addition = 1 + prev - current;
        count += addition;
        nums[i] += addition;
      }
    }

    return count;
    }
}