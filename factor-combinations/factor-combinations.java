class Solution {
    public List<List<Integer>> getFactors(int n) {
         List<List<Integer>> result = new ArrayList<>();
        if (n <= 3) {
            return result;
        }

        getFactorsHelper(n, 2, new ArrayList<>(), result);
        return result;
    }
    
    private void getFactorsHelper(int n, int factor, List<Integer> temp, List<List<Integer>> result) {
        // i * i <= n helps to avoid duplicates.
        for (int i = factor; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }

            temp.add(i);
            List<Integer> res = new ArrayList<>(temp);
            res.add(n / i);
            result.add(res);

            // No need to recurse if i*i > n/i as it will never enter this for loop. (Early Exit)
            if (i * i <= n / i) {
                getFactorsHelper(n / i, i, temp, result);
            }

            temp.remove(temp.size() - 1);
        }
    }
    
    
}