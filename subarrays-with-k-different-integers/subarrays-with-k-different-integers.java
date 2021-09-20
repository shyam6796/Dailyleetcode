class Solution {

       
     public int subarraysWithKDistinct(int[] ar, int k) {
	    // exact(k) == atMost(k) + atMost(k - 1)
        return atMostK(ar, k) - atMostK(ar, k-1);
    }
    
    private int atMostK(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < arr.length; right++) {
            int num = arr[right];
            addToMap(countMap, num);
            while (countMap.size() > k) {
                removeFromMap(countMap, arr[left]);
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
    
    private void addToMap(Map<Integer, Integer> countMap, int num) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    private void removeFromMap(Map<Integer, Integer> countMap, int num) {
        countMap.put(num, countMap.getOrDefault(num, 0) - 1);
        if (countMap.get(num) <= 0) {
            countMap.remove(num);
        }
    }
}