class Solution {
    public String reorganizeString(String s) {
       
    HashMap<Character,Integer> hm=new HashMap<>();
        char ch[]=s.toCharArray();
    for(char c:ch)
    {
      int count = hm.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (s.length() + 1) / 2) return "";
            hm.put(c, count);
    }
        //Using a max heap and sorting chacrters according to frequency
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> b[1]-a[1]); 
        // Adding all the values from the map to PriorityQueue
        for(Map.Entry<Character,Integer> map:hm.entrySet())
        {
            pq.offer(new int[]{map.getKey(),map.getValue()});
        }
 // USing StringBuilder because it is more efficient than normal string 
       StringBuilder sb=new StringBuilder(); 
     int store[]=new int[2];
        
     // Idea is to first store the charcter with largest frequency then store the charcter with the second largest frequency
        while(!pq.isEmpty())
        {
            int temp[]=pq.poll();       // poping out the chacrter with max frequency
            sb.append((char)temp[0]);   // storing the character 
            if(store[1]>0)              
             pq.offer(store);
            store=temp;
            store[1]-=1;
                    
        }
     return sb.toString();   
    }
    
}