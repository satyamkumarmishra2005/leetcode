class LRUCache {

    class Node{

        int value;
        int key;

        Node next;
        Node prev;

        Node(int value , int key){
            this.value = value;
            this.key = key;
        }
    }


    Node head;
    Node tail;

    int capacity;

    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {

        this.capacity = capacity;

        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node); // remove from previous position
        insert(node); // insert at front

        return node.value;
        
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node node = map.get(key);
            node.value = value;
            remove(node); // remove from current position
            insert(node); // insert at front

            return ;

        }

        if(map.size()== capacity){
            Node lru = tail.prev;
            remove(lru); // remove least recently used which is tail.prev last(node)
            map.remove(lru.key);
        }

        Node newnode = new Node(value, key);

        insert(newnode); // insert front
        map.put(key, newnode);
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    public void insert(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;


    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */