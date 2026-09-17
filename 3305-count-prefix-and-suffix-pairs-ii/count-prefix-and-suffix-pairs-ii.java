

// Solution Class
class Solution {
  // Method to count index pairs (i, j) where words[i] is both prefix and suffix
  // of words[j]
  public long countPrefixSuffixPairs(String[] words) {
    // Initialize the result variable as long to avoid overflow
    long result = 0;

    // Initialize the Trie
    Trie root = new Trie();

    // Iterate in reverse: query before insert enforces i < j
    for (int i = words.length - 1; i >= 0; i--) {
      result += root.count(words[i]);
      root.add(words[i]);
    }

    return result;
  }

  // Trie Class
  private class Trie {
    private final TrieNode root;

    public Trie() {
      this.root = new TrieNode();
    }

    // Insert a word using paired (front, back) character keys at each level
    private void add(String word) {
      TrieNode current = root;
      int length = word.length();

      for (int i = 0; i < length; i++) {
        String key = "" + word.charAt(i) + word.charAt(length - 1 - i);

        current.children.putIfAbsent(key, new TrieNode());
        current = current.children.get(key);
        current.count++;
      }
    }

    // Query: return the count of inserted words that word is a prefix-suffix of
    private int count(String word) {
      TrieNode current = root;
      int length = word.length();

      for (int i = 0; i < length; i++) {
        String key = "" + word.charAt(i) + word.charAt(length - 1 - i);

        if (!current.children.containsKey(key)) {
          return 0;
        }

        current = current.children.get(key);
      }

      return current.count;
    }
  }

  // TrieNode Class
  private class TrieNode {
    // HashMap keyed by 2-char string (paired front-back characters)
    private final HashMap<String, TrieNode> children;
    private int count;

    public TrieNode() {
      this.children = new HashMap<>();
      this.count = 0;
    }
  }
}

// Main Class
public class _3045_Count_Prefix_and_Suffix_Pairs_II {
  // Main method to test countPrefixSuffixPairs
  public static void main(String[] args) {
    String[] words = new String[] { "a", "aba", "ababa", "aa" };

    long result = new Solution().countPrefixSuffixPairs(words);

    System.out.println(
        "An integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true is : "
            + result);
  }
}