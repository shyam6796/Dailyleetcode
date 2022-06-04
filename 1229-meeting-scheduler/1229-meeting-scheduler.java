class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> list =new ArrayList<>();
        int i=0, j=0;
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        
        while(i<slots1.length && j <slots2.length){
            int start =Math.max(slots1[i][0],slots2[j][0]);
            int end = Math.min(slots1[i][1],slots2[j][1]);
            System.out.println(start +"  "+ end);
            if(end -start >=duration){
                list.add(start);
                list.add(start+duration);
                break;
            }
            if(slots1[i][1] >slots2[j][1]){
                j++;
            }else{
                i++;
            }
        }
        return list;
    }
}