package implement_trie;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode prev, cur = root;
        for (char ch : word.toCharArray()) {
            prev = cur;
            if (!prev.containsKey(ch)) {
                cur = new TrieNode();
                prev.put(ch, cur);
            } else {
                cur = prev.get(ch);
            }
        }
        cur.setIsEnd(true);
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.containsKey(ch)) {
                cur = cur.get(ch);
            } else {
                return false;
            }
        }
        return cur.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.containsKey(ch)) {
                cur = cur.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }
}
