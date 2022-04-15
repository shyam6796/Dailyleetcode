class Solution {
    char nums[];
    char ans[];
    int n;
    int target;
    List<String> list;
    public List<String> addOperators(String num, int target) {
        list= new ArrayList<>();
        nums =num.toCharArray();
        this.target=target;
        n=nums.length;
        ans =new char[n+n];
        long value=0;
        int index=0;
        for(int i=0; i<nums.length; i++){
            value = value*10 + nums[i]-'0';
            ans[index++]=nums[i];
            helper(i+1,index,value,0);
            if(value==0){
                break;
            }
        }
        return list;
    }
    public void helper(int i, int index, long prev, long curr){
        if(i==n){
            if(prev+curr ==target){
                list.add(new String(ans,0,index));
            }
            return;
        }
        long value=0;
        int op =index++;
        for(int j=i; j<n; j++){
            value = value *10 +nums[j] -'0';
            ans[index++]=nums[j];
            
            ans[op] ='+';
                 helper(j+1,index,value,curr+prev);
            ans[op] ='-';
                 helper(j+1,index,-value,curr+prev);
            ans[op] ='*';
                 helper(j+1,index,value*prev,curr);
             if(value==0)break;
        }
        
    }
}