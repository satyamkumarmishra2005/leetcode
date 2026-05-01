class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {

        TrieNode root = new TrieNode();

        // build trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }

        int maxXor = 0;

        // find max xor
        for (int num : nums) {
            TrieNode node = root;
            int curr = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int want = 1 - bit;

                if (node.children[want] != null) {
                    curr |= (1 << i);
                    node = node.children[want];
                } else {
                    node = node.children[bit];
                }
            }

            maxXor = Math.max(maxXor, curr);
        }

        return maxXor;
    }
}