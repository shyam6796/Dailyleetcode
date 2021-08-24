/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();
        
        while(head != null ){
            odd.add(head.val);
            if(head.next !=null)even.add(head.next.val);
            if(head.next !=null)head =head.next.next;
            else head =head.next;
        }
         ListNode ans =new ListNode(-1);
        ListNode temp =ans;
        while(!even.isEmpty() || !odd.isEmpty()){
           if(!even.isEmpty()){
               ans.next= new ListNode(even.poll());
               ans =ans.next;
           } 
           if(!odd.isEmpty()){
               ans.next= new ListNode(odd.poll());
               ans =ans.next;
           } 
            
        }
       return temp.next;
        
    }
}