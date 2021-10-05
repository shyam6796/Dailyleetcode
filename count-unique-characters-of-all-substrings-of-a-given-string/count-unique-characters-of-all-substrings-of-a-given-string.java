class Solution {
    public int uniqueLetterString(String s) {
            List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<26; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<s.length(); i++){
            list.get(s.charAt(i)- 'A').add(i);
        }
        long result =0;
        for(int i=0; i<26; i++){
            List<Integer> temp = list.get(i);
            for(int j=0; j<temp.size(); j++){
                int mylocation =temp.get(j);
                long left = (j==0 ? (mylocation +1) : mylocation - temp.get(j-1));
                long right =( j==temp.size()-1 ? s.length()-mylocation : temp.get(j+1) -mylocation);
                result =(left*right +result) %1000000007L;
                             
            }
        }
        return (int)result;
    }
}