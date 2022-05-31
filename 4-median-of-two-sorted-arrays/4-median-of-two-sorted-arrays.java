class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int medianPointer=0;
        int totalLength=nums1.length +nums2.length;
        int prev1=0, prev2=0;
        while((i<nums1.length || j<nums2.length) && medianPointer <= (totalLength)/2){
            if(j >=nums2.length || (i<nums1.length && nums1[i] <=nums2[j])){
                prev2 =prev1;
                prev1 =nums1[i];
                i++;
                
                    
            }else if(i>=nums1.length || (j<nums2.length && nums2[j] < nums1[i])){
                prev2 =prev1;
                prev1 =nums2[j];
                j++;
            }
             medianPointer++;
          //  System.out.println(prev1 +"  "+ prev2 +"  " +i+"  "+ j+ " "+ medianPointer );
           
        }
        
        return totalLength%2 !=0 ? prev1 : (prev1+prev2)/2.0;
    }
}