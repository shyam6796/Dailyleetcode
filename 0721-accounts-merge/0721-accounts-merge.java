class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        Set<String> visited =new HashSet<>();

        for(List<String> account : accounts){
            String email = account.get(1);
            if(!map.containsKey(email))map.put(email,new ArrayList<>());

            for(int i =2; i < account.size(); i++){
                String altemail =account.get(i);
                if(!map.containsKey(altemail))map.put(altemail,new ArrayList<>());
                map.get(email).add(altemail);
                map.get(altemail).add(email);
            }
        }

         for(List<String> account : accounts){
            String name =account.get(0);
            String email = account.get(1);
            if(!visited.contains(email)){
                List<String> ans = new ArrayList<>();
                ans.add(name);
                DFS(map,email,visited,ans);
                Collections.sort(ans.subList(1, ans.size()));
                list.add(ans);
            }
        }
        return list;
    }
    public void DFS(Map<String,List<String>> map, String email, Set<String> visited, List<String> ans){
        visited.add(email);
        ans.add(email);

        for(String str : map.get(email)){
            if(!visited.contains(str)){
                DFS(map, str, visited, ans);
            }
        }
        
    }
}