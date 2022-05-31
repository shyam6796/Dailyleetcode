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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Queue<Integer> q = new LinkedList<>();
        while(head  !=null){
            q.add(head.val);
            head =head.next;
        }
        ListNode temp =new ListNode(-1);
        ListNode ans = temp;
        int i=0,x=q.size()-n;
        while(!q.isEmpty()){ 
            //System.out.println(x + "  "+ i);
                if(i==x){
                  q.poll();
                }else{
                     temp.next =new ListNode(q.poll());
                     temp =temp.next;
                }
             i++;
                
            
        }
        return ans.next;
    }
}