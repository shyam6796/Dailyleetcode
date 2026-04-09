class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character,int[]> map = new HashMap<>();
        map.put('U',new int[]{0,1});
        map.put('D',new int[]{0,-1});
        map.put('L',new int[]{1,0});
        map.put('R',new int[]{-1,0});

        int x =0;
        int y =0;
        for(int i=0; i < moves.length(); i++){
            char c =moves.charAt(i);
            int dir[] =map.get(c);
            x = x+ dir[0];
            y = y+ dir[1];
        }
        return x==0 && y==0 ;

        
    }
}