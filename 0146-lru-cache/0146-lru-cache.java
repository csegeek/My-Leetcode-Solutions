class LRUCache {
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail =new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            Node ans=map.get(key);
            deleteNode(ans);
            insertNodeAthead(ans);
            return ans.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            insertNodeAthead(node);
        }
        else{
            if(map.size()>=capacity){
                Node delNode=this.tail.prev;
                deleteNode(delNode);
                Node newNode=new Node(key,value);
                map.remove(delNode.key);
                map.put(key,newNode);
                insertNodeAthead(newNode);
            }
            else{
                Node newNode=new Node(key,value);
                map.put(key,newNode);
                insertNodeAthead(newNode);
            }
        }
    }

    private void deleteNode(Node node){
     Node prev=node.prev;
     Node next=node.next;
     prev.next=next;
     next.prev=prev;
     node.next=null;
     node.prev=null;
    }

    private void insertNodeAthead(Node node){
     Node currHeadNext=this.head.next;
     head.next=node;
     node.prev=head;
     node.next=currHeadNext;
     currHeadNext.prev=node;
    }

    
}


class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.prev=null;
            this.next=null;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */