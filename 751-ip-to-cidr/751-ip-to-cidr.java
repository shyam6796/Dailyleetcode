class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> list =new ArrayList<>();
        long x = 0;
        String[] parts = ip.split("\\."); // we need \\ here because '.' is a keyword in regex.
    for(int i = 0; i < 4; i++) {
      x = x * 256 + Long.parseLong(parts[i]);
       
    }
    while(n>0){
        long count =x&(-x);
        
         if (count == 0) {
                count=(long)Math.pow(2,32);
            }
        
        while(count>n){
            count/=2;
        }
        list.add(oneCIDR(x,count));
        
        n =n -(int)count;
        x =x +(int)count;
    }
      
    return list;
    }
    
    public String oneCIDR(long x, long count){
        int d,b,c,a;
        StringBuilder sb =new StringBuilder();
        d = (int)x & 255;
        x >>= 8;
        c = (int)x & 255;
         x >>= 8;
        b = (int)x & 255;
        x >>= 8;
        a = (int)x & 255;
        x >>= 8;
        int len=0;
        while(count>0){
            count /=2;
            len++;
        }
        
        int mask =32-(len-1);
        
      return  sb.append(a).append(".").append(b).append(".").append(c).append(".").append(d).append("/").append(mask).toString();
        
        
    }
}