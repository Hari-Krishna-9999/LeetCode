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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode gprev = dummy;
        while(true){
            ListNode kth = gprev;
            for(int i = 0;i < k;i++){
                kth = kth.next;
                if(kth == null){
                    return dummy.next;
                }
            }

            ListNode newEnd = kth.next;
            ListNode prev = newEnd;
            ListNode curr = gprev.next;
            while(curr != newEnd){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp1 = gprev.next;
            gprev.next = prev;
            gprev = temp1;
        }
    }
}