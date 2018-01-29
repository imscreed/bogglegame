import javax.swing.tree.TreeNode;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = (char) (word.charAt(i) - 'a');

            if (current.child[ch] == null) {
                current.child[ch] = new TrieNode();
            }
            current = current.child[ch];
        }
        current.isWord = true;
    }

    public boolean contains(String word) {
        return find(word, "wordsearch");
    }

    public boolean startsWith(String prefix) {
        return find(prefix, "prefix");
    }

    private Boolean find(String word, String type){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = (char) (word.charAt(i) - 'a');
            if (current.child[ch] == null) {
                return false;
            }
            current = current.child[ch];
        }
        if(type.equals("prefix")) return true;
        else return current.isWord;
    }

    private void printTrie(TrieNode root) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.child.length; i++) {
            if (root.child[i] != null) {
                System.out.println((char) (i + 'a'));
                printTrie(root.child[i]);
            }
        }
    }

    public void testTrie(){
        printTrie(root);
    }

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord;

        public TrieNode() {
        }
    }
}
