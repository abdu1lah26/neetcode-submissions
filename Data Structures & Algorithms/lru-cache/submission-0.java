class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {

    int cap;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        left.next = right;
        right.prev = left;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;

        prev.next = nxt;
        nxt.prev = prev;
    }

    public void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
