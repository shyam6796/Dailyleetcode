/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
       int value=0;
        while(!q.isEmpty()){
            int temp =q.poll();
            for(Employee E : employees){
                if(E.id ==temp){
                    value +=E.importance;
                    for(int i : E.subordinates){
                        q.add(i);
                    }
                    break;
                }
            }
        }
        return value;
    }
    
}