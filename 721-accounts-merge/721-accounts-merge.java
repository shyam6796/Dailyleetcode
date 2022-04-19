class Solution {
    Map<String,List<String>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for(List<String> account : accounts){
            String firstemail = account.get(1);
            if(!map.containsKey(firstemail)){
                map.put(firstemail,new ArrayList<>());
            }
           
            for(int i=2; i<account.size(); i++){
                String email =account.get(i);
                
                map.get(firstemail).add(email);
                if(!map.containsKey(email)){
                    map.put(email, new ArrayList<>());
                }
                map.get(email).add(firstemail);
            }
        }
        
        List<List<String>> list = new ArrayList<>();
        
        for(List<String> account :accounts){
             List<String> mergeAccount = new ArrayList<>();
            mergeAccount.add(account.get(0));
            String firstEmail =account.get(1);
            if(!visited.contains(firstEmail)){
                 helepr(mergeAccount,firstEmail);
                Collections.sort(mergeAccount.subList(1,mergeAccount.size()));
                list.add(mergeAccount);
            }
        }
        
        return list;
    }
    
    public void helepr(List<String> mergeAccount, String email){
        mergeAccount.add(email);
       visited.add(email);
        if(!map.containsKey(email)) return;
        
        for(String s : map.get(email)){
            if(!visited.contains(s)){
                 helepr(mergeAccount,s);
            }
        }
    }
}