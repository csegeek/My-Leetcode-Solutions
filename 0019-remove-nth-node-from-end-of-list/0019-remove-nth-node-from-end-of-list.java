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
        ListNode dummy=new ListNode(-1,head);
        ListNode front=dummy;
        ListNode back=dummy;
        for(int i=0;i<=n;i++){
                     front=front.next;
        }
        while(front !=null){
            front=front.next;
            back=back.next;
        }
        ListNode delNode=back.next;
        back.next=delNode.next;
        delNode.next=null;
       return dummy.next; 
    }
}