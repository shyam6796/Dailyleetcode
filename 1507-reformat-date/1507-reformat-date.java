class Solution {
    public String reformatDate(String date) {
        Map<String,String> map =new HashMap<>();
        String [] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] data = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        for(int i=0; i<12; i++){
            map.put(month[i],data[i]);
        }
        String Date[] =date.split(" ");
        StringBuilder sb =new StringBuilder();
        int index=0, value=0;
        while(index <Date[0].length() && Character.isDigit(Date[0].charAt(index))){
            value =value *10 +Date[0].charAt(index++)-'0';
        }
          sb.append(Date[2] +"-");
           sb.append(map.get(Date[1]) +"-");  
            if(value<10)sb.append("0");
            sb.append(value);
       
      
        
        return sb.toString();
    }
}