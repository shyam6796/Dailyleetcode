class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set =new HashSet<>(wordList);
        if(!set.contains(endWord))return 0;
        Queue<String> queue =new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int steps = 1;

        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i = 0; i < size; i++){
                String currWord = queue.poll();
                if(currWord.equals(endWord))return steps;

                char arr[] = currWord.toCharArray();
                for(int j =0; j < arr.length; j++){
                    char k = arr[j];

                    for(char c ='a'; c <='z'; c++){
                        if(k==c)continue;
                        arr[j]=c;
                        String newWord = new String(arr);
                        
                        if(set.contains(newWord) && !visited.contains(newWord)){
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    arr[j] =k;
                }
            }
            steps++;
        }
        return 0;
    }
}