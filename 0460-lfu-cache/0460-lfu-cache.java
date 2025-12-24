class LFUCache {
        Map<Integer,Pair> freqMap;
        Map<Integer,Node> cacheMap;
        int minFreq;
        int capacity;
        
    public LFUCache(int capacity) {
       freqMap=new HashMap<>();
       cacheMap=new HashMap<>();
       minFreq=0;
       this.capacity=capacity;
    }
    
    public int get(int key) {
      if(!cacheMap.containsKey(key))  return -1;
      else{
        Node res=cacheMap.get(key);
        updateFreq(res);
        return res.value;
      }
    }
    
    public void put(int key, int value) {
        if(capacity==0) return ;
        if(cacheMap.containsKey(key)){
            Node node=cacheMap.get(key);
            node.value=value;
            updateFreq(node);
        }
        else{
            if(cacheMap.size()==capacity){
             Node deleteNode=freqMap.get(minFreq).tail.prev;
             remove(deleteNode);
             cacheMap.remove(deleteNode.key);
              
             if(freqMap.get(minFreq).head.next==freqMap.get(minFreq).tail){
                freqMap.remove(minFreq);
             }
            }

                Node node =new Node(key,value);
                cacheMap.put(key,node);
                add(node,1);
                minFreq=1;
           
        }
    }

    public void updateFreq(Node node){
        int oldfreq=node.cnt;
        node.cnt++;
        remove(node);
        if(freqMap.get(oldfreq).head.next==freqMap.get(oldfreq).tail){
            freqMap.remove(oldfreq);
            if(minFreq==oldfreq) minFreq++;
        }
        add(node,node.cnt);
    }
    public void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        node.prev=null;
        node.next=null;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
   public void add(Node node, int freq){
      if(!freqMap.containsKey(freq)){
       Node head=new Node(-1,-1);
       Node tail=new Node(-1,-1);
       head.next=tail;
       tail.prev=head;
       freqMap.put(freq,new Pair(head,tail));
      }
      //add just after head
      Node head=freqMap.get(freq).head;
      Node headNext=head.next;
      head.next=node;
      node.prev=head;
      node.next=headNext;
      headNext.prev=node;
   }


}


    class Node {
        int key;
        int value;
        int cnt;
        Node next;
        Node prev;

       Node(int key,int val){
       this.key=key;
       this.value=val;
       this.cnt=1;
       this.next=null;
       this.prev=null;
      }
    }

   class Pair {
    Node head;
    Node tail;
     Pair(Node head,Node tail){
        this.head=head;
        this.tail=tail;
    }
   }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */