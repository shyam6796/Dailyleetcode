

import static java.util.Collections.max;

class Solution {
    public int[] sortArray(int[] arr) {
        int minVal = arr[0], maxVal = arr[0];
        HashMap<Integer,Integer> counts = new HashMap<>();
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
            counts.put(arr[i], counts.getOrDefault(arr[i], 0) + 1);
        }

        for(int val = minVal; val <=maxVal; val++){
            while(counts.getOrDefault(val,0) > 0){
                arr[index++] =val;
                counts.put(val,counts.get(val)-1);
            }
        }


        return arr;
    }
}