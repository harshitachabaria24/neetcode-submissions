class TrieNode {

    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Same as Trie Insert
    public void addWord(String word) {

        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {

        // Base Case
        if (index == word.length()) {
            return node.isWord;
        }

        char ch = word.charAt(index);

        // Wildcard '.'
        if (ch == '.') {

            for (int i = 0; i < 26; i++) {

                if (node.children[i] == null) {
                    continue;
                }

                if (dfs(node.children[i], word, index + 1)) {
                    return true;
                }
            }

            return false;
        }

        // Normal Character
        int child = ch - 'a';

        if (node.children[child] == null) {
            return false;
        }

        return dfs(node.children[child], word, index + 1);
    }
}