class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;

        while (i < chars.length) {
            int count = 1;

            while (i + count < chars.length && chars[i + count] == chars[i]) {
                count++;
            }
            chars[index++] = chars[i];
            if (count > 1) {
                char arr[] = String.valueOf(count).toCharArray();
                for (char c : arr) {
                    chars[index++] = c;
                }
            }

            i = i + count;

        }
        return index;
    }
}