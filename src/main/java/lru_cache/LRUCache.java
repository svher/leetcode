package lru_cache;

public interface LRUCache {
    int get(int key);

    void put(int key, int value);
}
