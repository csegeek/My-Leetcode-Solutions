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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode middleNode=getMiddleNode(head);
          //System.out.println(middleNode.val);
        ListNode reversedHead=reverse(middleNode);
        ListNode curr=head;
        while(curr!=null && reversedHead!=null){
            if(curr.val!=reversedHead.val) return false;
           curr=curr.next ;
           reversedHead=reversedHead.next;
        }
        return true;
    }
    private ListNode getMiddleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node){
        if(node==null || node.next==null) return node;
        ListNode curr=node;
        ListNode newNode=reverse(node.next);
        curr.next.next=curr;
        curr.next=null;
        return newNode;
    }

}