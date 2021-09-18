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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
           
        
        for(int i=0 ;i<lists.length; i++){
            ListNode root =lists[i];
            while(root !=null){
                queue.add(root.val);
                root =root.next;
            }
        }
        if(queue.isEmpty())return null;
        ListNode ans = new ListNode(queue.poll());
         ListNode res =ans;
        
        while(!queue.isEmpty()){
            ans.next =new ListNode(queue.poll());
            ans= ans.next;
        }
        return res;
    }
}