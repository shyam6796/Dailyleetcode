class Solution {
    Map<String,List<String>> map = new HashMap<>();
    Set<String> visited =new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        List<List<String>> mergeAccounts = new ArrayList<>();
        
        for(List<String> list : accounts){
            String firstEmail =list.get(1);
            if(!map.containsKey(firstEmail)){
                map.put(firstEmail,new ArrayList<>());
            }
          for(int j =2; j<list.size(); j++){
                String email =list.get(j);
                
                map.get(firstEmail).add(email);
                if(!map.containsKey(email)){
                    map.put(email, new ArrayList<>());
                }
                map.get(email).add(firstEmail);
            }
        }
        
        for(List<String> list : accounts){
            List<String> mergeAccount = new ArrayList<>();
            mergeAccount.add(list.get(0));
            String firstEmail =list.get(1);
           if(!visited.contains(firstEmail)){ 
                helper(mergeAccount,firstEmail);
                Collections.sort(mergeAccount.subList(1,mergeAccount.size()));
                mergeAccounts.add(mergeAccount);        
            }
        }
        return mergeAccounts;
    }
    public void helper(List<String>mergeAccount, String email){
        mergeAccount.add(email);
         visited.add(email);
        if(!map.containsKey(email)){
            return ;
        }
        for(String neighbor : map.get(email)){
            if (!visited.contains(neighbor)) {
                helper(mergeAccount, neighbor);
            }
        }
    }
}