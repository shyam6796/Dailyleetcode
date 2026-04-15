class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
         PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        int time =0;

        for(char c :tasks){
            freq[c-'A']++;
        }

        for(int i=0; i <freq.length; i++){
            if(freq[i]!=0)queue.add(freq[i]);
        }

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<=n; i++){
                if(queue.isEmpty())break;
                list.add(queue.poll());
            }
            for(int i : list){
                if(i >1)queue.add(i-1);
            }
            time += queue.isEmpty()  ? list.size() : n+1;
        }
        return time;
    }
}