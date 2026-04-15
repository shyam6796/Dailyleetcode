class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int count =p.length();
        int freq[] =new int[26];
        int left =0;
        int right =0;

        for(char c : p.toCharArray()){
            freq[c -'a']++;
        }

        while(right < s.length()){
            char c =s.charAt(right);
            
            if(freq[c-'a'] >=1)count--;
            freq[c-'a']--;

            if(count ==0)list.add(left);

            if(right -left +1 >=p.length()  && freq[s.charAt(left++) -'a']++ >=0){
                    count++;
            }
            right++;
        }
        return list;
    }
}