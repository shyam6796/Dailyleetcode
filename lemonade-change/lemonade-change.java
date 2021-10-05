class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer,Integer> map  =new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        
        for(int i : bills){
            // System.out.println(map);
            if(i==5){
                map.put(5,map.get(5)+1);
                continue;
            }
            if(i==10){
                 if(map.get(5)>0){
                     map.put(10,map.get(10)+1);
                     map.put(5,map.get(5)-1);
                     continue;
                 }else{
                     return false;
                 }
            }
            if(i==20){
                if(map.get(5)>0 && map.get(10)>0){
                    map.put(20,map.get(20)+1);
                     map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                     continue;
                 }else if(map.get(5)>3){
                      map.put(20,map.get(20)+1);
                     map.put(5,map.get(5)-3);   
                }else{
                    return false;
                }
                    
            }
            
        }
       
        return true;
    }
}