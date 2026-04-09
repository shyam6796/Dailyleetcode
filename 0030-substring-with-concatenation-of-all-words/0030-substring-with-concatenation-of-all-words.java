class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words.length == 0)
            return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int wordCount = words.length;
        int wordLength = words[0].length();
        List<Integer> list = new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            Map<String, Integer> windowMap = new HashMap<>();
            int count = 0;

            for (int right = left; right + wordLength <= s.length(); right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (map.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowMap.get(word) > map.get(word)) {
                        String leftword = s.substring(left, left + wordLength);
                        windowMap.put(leftword, windowMap.get(leftword) - 1);
                        count--;
                        left += wordLength;
                    }
                    if (count == wordCount) {
                        list.add(left);
                    }
                } else {
                    left = right + wordLength;
                    windowMap.clear();
                    count = 0;
                }
            }
        }
        return list;
    }
}