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
    public void reorderList(ListNode head) {
        if(head ==null || head.next==null)return;
        ListNode fast =head;
        ListNode slow = head;
        ListNode first=head;
        ListNode second;

        while(fast !=null && fast.next !=null){
            fast =fast.next.next;
            slow =slow.next;
        }

        second =reverse(slow);

        while(second.next !=null){
            ListNode temp =first.next;
            first.next =second;
            first =temp;

            temp =second.next;
            second.next =first;
            second= temp;
            
            
        }


    }
    public ListNode reverse(ListNode head){
        ListNode prev =null;
        while(head !=null){
            ListNode temp =head.next;
            head.next =prev;
            prev =head;
            head =temp;
        }
        return prev;
    }
}