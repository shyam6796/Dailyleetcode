class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i =0; i <numRows; i++){
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            if(i==0){
                list.add(tempList);
                continue;
            }
            for(int j=1; j <i; j++){
                tempList.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            tempList.add(1);
            list.add(tempList);
        }
        return list;
    }
}