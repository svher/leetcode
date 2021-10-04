package implement_trie;

public class TrieNode {

    private TrieNode[] children = new TrieNode[26];
    private boolean isEnd = false;

    public TrieNode() {

    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
