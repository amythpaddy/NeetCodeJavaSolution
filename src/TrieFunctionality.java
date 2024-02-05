public class TrieFunctionality {
    public static void main(String[] args) {

    }

    static class Trie {
        TrieNode tn;

        public Trie() {
            tn = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = tn;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.endWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = tn;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return curr.endWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = tn;
            for (char c : prefix.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    return false;
                }
                curr = curr.children.get(c);
            }
            return true;
        }
    }
}
