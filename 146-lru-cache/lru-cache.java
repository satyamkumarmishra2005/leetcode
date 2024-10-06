import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    private LinkedList<Integer> dll;  // To store the keys
    private Map<Integer, Pair> cache; // To store the key -> (iterator, value) mapping
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dll = new LinkedList<>();
        this.cache = new HashMap<>();
    }

    private void makeMostRecentlyUsed(int key) {
        dll.remove((Integer) key);  // Remove the key from its current position
        dll.addFirst(key);  // Add it to the front
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        makeMostRecentlyUsed(key);
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.get(key).value = value;
            makeMostRecentlyUsed(key);
        } else {
            dll.addFirst(key);
            cache.put(key, new Pair(dll.iterator(), value));
            capacity--;
        }

        if (capacity < 0) {
            int leastUsedKey = dll.removeLast();
            cache.remove(leastUsedKey);
            capacity++;
        }
    }

    // Helper class to store the iterator and the value together
    class Pair {
        private java.util.Iterator<Integer> iterator;
        private int value;

        public Pair(java.util.Iterator<Integer> iterator, int value) {
            this.iterator = iterator;
            this.value = value;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */