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

        ListNode temp=head;
        ListNode prevNode=null;
        ListNode nextNode=null;
        while(temp!=null){
            ListNode kthNode=findkthNode(temp,k);
            if(kthNode==null){
              if(prevNode!=null) prevNode.next=temp;
              break;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            ListNode reversedHead=reverse(temp);
            if(temp==head){
                head=reversedHead;
            }
            else{
               if(prevNode!=null) prevNode.next=reversedHead;
            }

            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }

    private ListNode findkthNode(ListNode head,int k){
        if(k<=1) return head;

        ListNode temp=head;
        while(temp !=null && k>1){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode curr=head;
        ListNode newNode=reverse(curr.next);
        curr.next.next=curr;
        curr.next=null;
        return newNode;
    }

}