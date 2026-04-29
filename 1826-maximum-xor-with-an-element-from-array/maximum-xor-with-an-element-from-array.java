class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();

    // Insert number into Trie
    void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Get max XOR
    int getMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (node.children[opposite] != null) {
                maxXor |= (1 << i);
                node = node.children[opposite];
            } else {
                node = node.children[bit];
            }
        }

        return maxXor;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;
        int[][] qArr = new int[q][3];

        for (int i = 0; i < q; i++) {
            qArr[i] = new int[]{queries[i][0], queries[i][1], i};
        }

        Arrays.sort(qArr, (a, b) -> a[1] - b[1]);

        int[] result = new int[q];
        int i = 0;

        for (int[] query : qArr) {
            int x = query[0];
            int m = query[1];
            int idx = query[2];

            // Insert valid nums
            while (i < nums.length && nums[i] <= m) {
                insert(nums[i]);
                i++;
            }

            if (i == 0) {
                result[idx] = -1;
            } else {
                result[idx] = getMaxXor(x);
            }
        }

        return result;
    }
}