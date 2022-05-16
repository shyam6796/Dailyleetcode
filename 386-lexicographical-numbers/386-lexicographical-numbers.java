class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list =new ArrayList<>();
        for(int i=1;i<=9;i++)
        {
            dfs(list,n,i);
        }       
        return list;
    }
    public void dfs( List<Integer> list, int n, int curr){
        if(curr >n)return;
        list.add(curr);
        for(int i=0; i<=9; i++){
            int nextNum = curr * 10 + i;
            if(nextNum>n)return;
            dfs(list,n,nextNum);
        }
    }
}