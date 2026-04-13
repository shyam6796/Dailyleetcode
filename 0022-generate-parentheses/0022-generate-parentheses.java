class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list,"",0,0,n);
        return list;
    }
    public void helper(List<String>list, String str, int i, int j,int n){
        if(2*n ==str.length()){
            list.add(str);
            return;
        }
        if(i <n )helper(list, str+"(", i+1, j, n);
        if(j <i)helper(list, str+")", i, j+1, n);
    }
}