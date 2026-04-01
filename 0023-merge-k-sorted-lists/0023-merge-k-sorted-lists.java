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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val -b.val);
        for(ListNode ls : lists){
            if(ls !=null)queue.add(ls);
        }

        ListNode ans =new ListNode(-1);
        ListNode head =ans;

        while(!queue.isEmpty()){
            ListNode curr =queue.poll();
            ans.next =curr;
            ans =ans.next;
            if(curr.next !=null)queue.add(curr.next);
        }
        return head.next;
    }
}