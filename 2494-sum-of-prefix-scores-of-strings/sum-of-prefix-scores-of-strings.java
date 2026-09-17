

import java.util.Arrays;

// Solution Class
class Solution {
  // Method to find an array answer of size n where answer[i] is the sum of scores
  // of every non-empty prefix of words[i]
  public int[] sumPrefixScores(String[] words) {
    // Build the Trie from all words
    Trie trie = new Trie(words);

    // Compute prefix score sum for each word
    int[] result = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      result[i] = trie.getScore(words[i]);
    }

    // Return the result
    return result;
  }

  // Trie Class
  private class Trie {
    private final TrieNode root;

    public Trie(String[] words) {
      this.root = new TrieNode();

      for (String word : words) {
        this.addWord(word);
      }
    }

    // Insert a word, incrementing totalWords at each node along the path
    private void addWord(String word) {
      TrieNode current = this.root;

      for (char c : word.toCharArray()) {
        if (current.children[c - 'a'] == null) {
          current.children[c - 'a'] = new TrieNode();
        }

        current = current.children[c - 'a'];

        // Count how many words pass through this node (= prefix frequency)
        current.totalWords++;
      }
    }

    // Sum totalWords along the word's Trie path = sum of prefix scores
    private int getScore(String word) {
      TrieNode current = this.root;
      int score = 0;

      for (char c : word.toCharArray()) {
        current = current.children[c - 'a'];
        score += current.totalWords;
      }

      return score;
    }
  }

  // TrieNode Class
  private class TrieNode {
    private final TrieNode[] children;
    private int totalWords;

    public TrieNode() {
      this.children = new TrieNode[26];
      this.totalWords = 0;
    }
  }
}

// Main Class
public class _2416_Sum_of_Prefix_Scores_of_Strings {
  // Main method to test sumPrefixScores
  public static void main(String[] args) {
    String[] words = new String[] { "abc", "ab", "bc", "b" };

    int[] result = new Solution().sumPrefixScores(words);

    System.out.println(
        "An array answer of size n where answer[i] is the sum of scores of every non-empty prefix of words[i] is : "
            + Arrays.toString(result));
  }
}