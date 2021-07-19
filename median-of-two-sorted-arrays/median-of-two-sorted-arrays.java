class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p = nums1.length, q = nums2.length;
        int n = p+q;
        double mid1 = 0, mid2 = 0;
        int j = 0 , k = 0 ;
        for(int i = 1 ; i<=(int)n/2+1 ; i++){
            if(i==(int)n/2+1)mid2=mid1;
            if(j<p && k<q){
                mid1 = (nums1[j]<nums2[k])?nums1[j]:nums2[k];
                if(mid1==nums1[j])j++;else k++;
            }else{
                if(k<q && j>=p){
                    mid1=nums2[k];k++;
                }else{
                    mid1=nums1[j];j++;
                }
            }
        }

        if(n%2!=0)return (double)mid1;
        return (double)(mid1+mid2)/2;
    }
}