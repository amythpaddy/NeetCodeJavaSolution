import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean endWord;
    String value;

    public TrieNode() {
        children = new HashMap<>();
        endWord = false;
        value = "";
    }
}
