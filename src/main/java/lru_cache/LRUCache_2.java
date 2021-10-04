package lru_cache;

import java.util.Map;

public class LRUCache_2 implements LRUCache {

    private int capacity;

    class LinkedNode {
        int key, val;
        LinkedNode before, after;

        LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        LinkedNode() {

        }
    }

    public Map<Integer, LinkedNode> cache;

    private LinkedNode head, tail;

    public LRUCache_2(int capacity) {
        head = new LinkedNode();
        tail = new LinkedNode();
        head.after = tail;
        tail.before = head;
        this.capacity = capacity;
    }

    private void insert(LinkedNode node) {
        LinkedNode prev = tail.before;
        prev.after = node;
        node.before = prev;
        node.after = tail;
        tail.before = node;
    }

    private void remove(LinkedNode node) {
        node.before.after = node.after;
        node.after.before = node.before;
    }

    @Override
    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }

    @Override
    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            remove(node);
        } else {
            node = new LinkedNode(key, value);
            if (capacity == cache.size()) {
                cache.remove(key);
                remove(head.after);
            }
            cache.put(key, node);
        }
        insert(node);
    }
}
