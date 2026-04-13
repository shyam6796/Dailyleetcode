class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair<String,Double>>> map = new HashMap<>();
        double [] ans = new double[queries.size()];

        for(int i=0; i < equations.size(); i++){
            String a = equations.get(i).get(0);
            String b= equations.get(i).get(1);
            if(!map.containsKey(a))map.put(a,new ArrayList<>());
            if(!map.containsKey(b))map.put(b,new ArrayList<>());
            map.get(a).add(new Pair(b, values[i]));
            map.get(b).add(new Pair(a, 1.0/values[i]));
        }

        for(int i=0; i <queries.size(); i++){
            String start =queries.get(i).get(0);
            String target =queries.get(i).get(1);
            if(!map.containsKey(start) || !map.containsKey(target)){
                ans[i] =-1.0;
            }else{
                ans[i] =DFS(map,new HashSet<>(),start,target);
            }
        }
        return ans;


    }

    public double DFS(Map<String,List<Pair<String,Double>>> map, Set<String> set, String node ,String target){
        if(node.equals(target))return 1.0;

        set.add(node);
        double result =-1.0;
        List<Pair<String,Double>> list = map.get(node);
        for(Pair<String,Double> pr : list){
            if(pr.getKey().equals(target))return pr.getValue();
            if(!set.contains(pr.getKey())){
                result = pr.getValue() * DFS(map, set, pr.getKey(), target);
            }
        }
        
        return result;
    }
}