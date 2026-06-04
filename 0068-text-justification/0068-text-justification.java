class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int i = index + 1;

            while (i < words.length && totalChars + 1 + words[i].length() <= maxWidth) {
                totalChars += words[i].length() + 1;
                i++;
            }
            //totalChars =10 , index =0, i =3
            int gaps = i - index - 1;//2

            StringBuilder sb = new StringBuilder();
            if (gaps == 0 || i == words.length) {
                for (int j = index; j < i; j++) {
                    sb.append(words[j] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {
                int minExtraSpace = (maxWidth - totalChars) / gaps;
                int oddExtraSpace = (maxWidth - totalChars) % gaps;

                for (int j = index; j < i - 1; j++) {
                    sb.append(words[j] + " ");
                    sb.append(" ".repeat(minExtraSpace));
                    if (oddExtraSpace-- > 0)
                        sb.append(" ");
                }
                sb.append(words[i - 1]);

            }

           // System.out.println(sb.toString());

            list.add(sb.toString());
            //
            index =i;
        }
        return list;
    }
}