class Solution {
    int digits [] = {1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        helper(list,turnedOn,0,0,0);
        return list;
    }
    public void helper(List<String>list ,int turnedOn, int h ,int m, int index){
        if(turnedOn ==0){
            if(h <= 11 && m <= 59) {
                String str = h + ":" +(m <10 ? "0"+m: m);
                list.add(str);
            } 
            return;
        }

        for(int i =index; i <digits.length; i++){
            if(ishour(i)) h +=digits[i];
            else m +=digits[i];

            helper(list, turnedOn-1, h, m,i+1);
            if(ishour(i)) h-=digits[i];
            else m -=digits[i];
        }
    }

    public boolean ishour(int i){
        return i >=0 && i <=3;
    }
}