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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr =head;
        ListNode prev =null;

        while(left >1){
            prev =curr;
            curr =curr.next;
            left--;
            right--;
            
        }
        
        ListNode conn =prev;
        ListNode tail =curr;
        prev =null;

        for(int i =0; i <right; i++){
            ListNode temp =curr.next;
            curr.next =prev;
            prev =curr;
            curr =temp;
        }
        if(conn !=null)conn.next =prev;
        else head =prev;

        tail.next = curr;

        return head;
    }
}