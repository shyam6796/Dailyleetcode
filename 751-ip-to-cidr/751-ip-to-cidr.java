class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> list =new ArrayList<>();
        long x=0;
        String str [] = ip.split("\\.");
        for(int i=0; i<4; i++){
            x = x*256 +Long.parseLong(str[i]);
        }
        
        while(n>0){
           long count =x&(-x);
            
            if(count ==0){
                count =(long)Math.pow(2,32);
            }
            while(count >n){
                count/=2;
            }
            
            list.add(oneCIDR(count,x));
            
            n= n- (int)count;
            x =x +count;
        }
        return list;
    }
    
    public String oneCIDR(long count, long x){
        StringBuilder sb =new StringBuilder();
        int d,b,c,a;
        
        d =(int) x & 255;
        x>>=8;
        c =(int) x & 255;
         x>>=8;
        b =(int) x & 255;
         x>>=8;
        a =(int) x & 255;
        
        int len =0;
        while(count >0){
            count /=2;
            len++;
        }
        
        int mask =32-(len-1);
        
        sb.append(a).append(".").append(b).append(".").append(c).append(".").append(d).append("/").append(mask);
        
        return sb.toString();
    }
 }