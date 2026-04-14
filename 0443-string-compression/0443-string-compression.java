class Solution {
    public int compress(char[] chars) {
        int index =0;
        int right =0;

        while(right < chars.length){
            int count=1;
            int i =right+1;
            index =right+1;
            while(i <chars.length  && chars[right]==chars[i]){
                count++;
                i++;
            }
            if(count==1){
                right =i;
                continue;
            }
            char arr[] =String.valueOf(count).toCharArray();
            for(char c : arr){
                chars[index++]=c;
            }
            right=i;

           
        }
        return index;
    }
}