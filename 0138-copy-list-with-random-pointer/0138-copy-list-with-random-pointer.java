/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> randomNodeMap=new HashMap<>();
        Map<Node,Node> clonedNodeMap=new HashMap<>();
        Node curr=head;
        Node prev=null;
        Node newHead=null;
        while(curr!=null){
         Node newNode=new Node(curr.val);
         if(prev!=null)prev.next=newNode;
         else{
            newHead=newNode;
         }
         randomNodeMap.put(curr,curr.random);
         clonedNodeMap.put(curr,newNode);
         prev=newNode;
         curr=curr.next;
        }

        curr=head;
        while(curr!=null){
           clonedNodeMap.get(curr).random=clonedNodeMap.get(randomNodeMap.get(curr));
           curr=curr.next;
        }
       return newHead; 
    }
}