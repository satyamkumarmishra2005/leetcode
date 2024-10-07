class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    TrieNode getRoot() {
        return root;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            TrieNode node = trie.getRoot();
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                if (node.isEndOfWord) {
                    dp[j + 1] = true;
                }
            }
        }

        return dp[n];
    }
}