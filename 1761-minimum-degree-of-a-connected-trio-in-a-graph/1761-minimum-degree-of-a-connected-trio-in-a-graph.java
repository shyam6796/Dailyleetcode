class Solution {
    public int minTrioDegree(int n, int[][] edges) {
         //adjecency matrix
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] e : edges) {
            //2 lines approach
            graph.compute(e[0], (k,v) -> v == null ? new HashSet<Integer>() : v).add(e[1]);
            graph.compute(e[1], (k,v) -> v == null ? new HashSet<Integer>() : v).add(e[0]);
        }
        int degree = Integer.MAX_VALUE;
        for(int[] e : edges) {
            HashSet<Integer> x = graph.get(e[0]);
            HashSet<Integer> y = graph.get(e[1]);
            
            for(int num : x) {
                if(y.contains(num)) { // found trio
                    // degree = (total edges from x) 
                    //        + (total edges from y) + (total edges from num) - 6
                    // why 6? : If Trio degree is ZERO then it will have 6 edges 
                    // i.e. count for edge from each connected node in Trio
                    int total = x.size() + y.size() + graph.get(num).size() - 6;
                    degree = Math.min(degree, total);
                }
            }
        }
        
        return degree == Integer.MAX_VALUE ? -1 : degree;
    }
}