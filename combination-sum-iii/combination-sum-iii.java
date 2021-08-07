class Solution {
     List<List<Integer>> result = new ArrayList();
    Integer totalLength;
    public List<List<Integer>> combinationSum3(int k, int n) {
        totalLength = k;
        backtrack(new ArrayList(), 1, 0, totalLength, n);
        return result;
    }
    
    public void backtrack(List<Integer> temp, int start, int sum, int numLength, int target) {
        if(sum == target && numLength == totalLength)
            result.add(new ArrayList(temp));
        else if( sum > target)
            return;
        else{
            for(int i = start; i <= 9;i++){
                temp.add(i);
                sum += i;
                backtrack(temp, i + 1, sum, temp.size(), target);
                sum -= i;
                temp.remove(temp.size()-1);
            }
        }
    }
}