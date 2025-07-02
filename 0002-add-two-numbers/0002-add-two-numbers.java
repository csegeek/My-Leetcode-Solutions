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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        // int sum=l1.val+l2.val;
        // int value=sum%10;
        // int remain=sum/10;
        // head.val=value;
         recursiveSol(l1,l2,head,0);
        return head.next;
    }
   private void recursiveSol(ListNode l1, ListNode l2, ListNode response, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }

        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }

        int value = sum % 10;
        int newCarry = sum / 10;

        ListNode temp = new ListNode(value);
        response.next = temp;

        recursiveSol(l1 != null ? l1.next : null,
                     l2 != null ? l2.next : null,
                     response.next,
                     newCarry);
    }
}