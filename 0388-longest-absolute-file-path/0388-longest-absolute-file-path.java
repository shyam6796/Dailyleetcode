class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int maxLength = 0;
        HashMap<Integer, Integer> pathLengths = new HashMap<>(); // depth: length detrmind by space ex : 0 space 0 dept 1 space 1 dept etc

        for (String line : lines) {
            String name = line.replaceAll("\t", "");
            int depth = line.length() - name.length();
            boolean isFile = name.contains(".");

            if (isFile) {
                maxLength = Math.max(maxLength, pathLengths.getOrDefault(depth, 0) + name.length());
            } else {
                pathLengths.put(depth + 1, pathLengths.getOrDefault(depth, 0) + name.length() + 1); // 1 for the '/'
            }
        }
        

        return maxLength;
    }
}