class Solution {
    int count=1;
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list =new ArrayList<>();
      //  for(int i=1;i<=9;i++)
       // {
            System.out.println(count++);
            dfs(list,n,1);
        //}       
        return list;
    }
    public void dfs( List<Integer> list, int n, int curr){
        System.out.println(count++);
        if(curr >n)return;
        list.add(curr);
         dfs(list,n,curr*10);
        if(curr%10 != 9){
            dfs(list,n,curr+1);
        }
    }
}