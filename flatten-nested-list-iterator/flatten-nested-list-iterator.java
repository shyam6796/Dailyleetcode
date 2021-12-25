/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list = new ArrayList<>();
    int pos=0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        helperNestedIterator(nestedList);
    }
    
    public void helperNestedIterator(List<NestedInteger> nestedList){
        for(NestedInteger i : nestedList){
            if(i.isInteger()){
                list.add(i.getInteger());
            }else{
               helperNestedIterator(i.getList());
            }
        }      
    }
    
    

    @Override
    public Integer next() {
         
        return list.get(pos++);
        
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */