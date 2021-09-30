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
    public ListNode rotateRight(ListNode head, int k) {
        if(head ==null)return null;
        ListNode count =head;
        int c=0;
        while(count!=null){
            count=count.next;
            c++;
        }
        k=k%c;
       ListNode ans = head;
        for(int i =0; i<k; i++){
             ListNode temp =ans;
             ListNode t1 =ans;
            while(temp.next !=null && temp.next.next != null ){
                temp =temp.next;
            }
            if(temp.next !=null){
                ans = temp.next;
            temp.next =null;
            ans.next=t1;
            }
            }
        return ans;
       
    }
}