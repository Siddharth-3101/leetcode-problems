class Node{
    public int val;
    public Node next;
    public Node prev;
    public int key;
    public Node(){

    }
}

class LRUCache {
    int cap;
    HashMap<Integer,Node> map=new HashMap<>();
    Node head=new Node();
    Node tail=new Node();
    public void addNode(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public LRUCache(int capacity) {
        head.next=tail;
        tail.prev=head;
        cap=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        Node node=map.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            removeNode(node);
            addNode(node);
        }
        else{
            Node node=new Node();
            node.key=key;
            node.val=value;
            addNode(node);
            map.put(key,node);
            if(map.size()>cap){
                Node lru=tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */