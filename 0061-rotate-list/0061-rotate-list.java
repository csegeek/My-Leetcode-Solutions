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
        if(head==null) return head;
        int n=findLength(head);
        if(k==n) return head;
        if(k>n)k=k%n;
        ListNode back=head;
        ListNode front=head;

        while(k>0){
         front=front.next;
         k--;   
        }
        while(front !=null && front.next!=null){
            back=back.next;
            front=front.next;
        }
        ListNode nextNode=back.next;
        back.next=null;
        front.next=head;
        head=nextNode;
        return head;

    }

    private int findLength(ListNode head){
        if(head==null) return 0;
        int length=0;
        while(head !=null){
         head=head.next ;
         length++;
        }
        return length;
    }

}