class Solution {
    public List<String> removeSubfolders(String[] ar) {
           Set<String> hs = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = ar.length;
        for(String val: ar) hs.add(val);
        for(int i=0; i<n; i++){
            String cur = ar[i];
            int len = cur.length();
            boolean add = true;
            for(int j=1; j<len; j++){
                if(cur.charAt(j) != '/') continue;
                String temp = cur.substring(0,j);
                if(hs.contains(temp)) {
                    add = false;
                    break;
                }
            }
            if(add) res.add(cur);
        }
        return res;
    }
}