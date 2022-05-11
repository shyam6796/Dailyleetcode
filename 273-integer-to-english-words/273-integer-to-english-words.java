class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        TreeMap<Integer,String> map =new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        
        map.put(0,"Zero");
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");                                                    
        map.put(14,"Fourteen");                                                             
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80, "Eighty");
        map.put(90,"Ninety");
        map.put(100,"Hundred");
        map.put(1000 , "Thousand");
        map.put(1000000,"Million");
        map.put(1000000000,"Billion");
        
        while(num >0){
            int key = map.floorKey(num);
            int value =num/key;
            if(key<100){
                sb.append(" ").append(map.get(key));
            }else if(value<100 && map.containsKey(value)){
                 sb.append(" ").append(map.get(value)).append(" ").append(map.get(key));
            }else{
                 sb.append(" ").append(numberToWords(value)).append(" ").append(map.get(key));
            }
            num =num%key;
        }
        return sb.toString().trim();
    }
}