import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[2];
        int count = 0;
    }

    TrieNode root = new TrieNode();

    void insert(int num) {
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
            node.count++;
        }
    }

    void remove(int num) {
        TrieNode node = root;
        for (int i = 20; i >= 0; i--) {
            int bit = (num >> i) & 1;
            node = node.children[bit];
            node.count--;
        }
    }

    int maxXor(int num) {
        TrieNode node = root;
        int res = 0;

        for (int i = 20; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int want = 1 - bit;

            if (node.children[want] != null && node.children[want].count > 0) {
                res |= (1 << i);
                node = node.children[want];
            } else {
                node = node.children[bit];
            }
        }

        return res;
    }

    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {

            insert(nums[r]);

            while (nums[l] * 2 < nums[r]) {
                remove(nums[l]);
                l++;
            }

            ans = Math.max(ans, maxXor(nums[r]));
        }

        return ans;
    }
}