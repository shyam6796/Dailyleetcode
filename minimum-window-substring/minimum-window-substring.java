class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
          return "";
      }
        HashMap<Character,Integer> dit = new HashMap<>();
        char arr[] = t.toCharArray();
        for(char C : arr){
            int count = dit.getOrDefault(C,0);
            dit.put(C,count+1);
        }
        
        int []ans = new int[]{-1,0,0};
        int r=0, l=0;
        int formed=0;
        HashMap<Character,Integer> temp = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            temp.put(c,temp.getOrDefault(c,0)+1);
            
            if( dit.containsKey(c) && dit.get(c).intValue() == temp.get(c).intValue()){
                formed++;
            }
            
            while(l <=r && formed ==dit.size()){
                c= s.charAt(l);
                if(ans[0] ==-1 || r-l+1 <ans[0]){
                    ans[0]= r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                  temp.put(c,temp.getOrDefault(c,0)-1);
                 if( dit.containsKey(c) && dit.get(c).intValue() > temp.get(c).intValue()){
                    formed--;
                }
                l++;
                
            }
            r++;
            
        }
        return ans[0]==-1 ?"" :s.substring(ans[1],ans[2]+1);
    }
}