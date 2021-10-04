package lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache_1 implements LRUCache {

    public LinkedHashMap<Integer, Integer> cache;

    public LRUCache_1(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
