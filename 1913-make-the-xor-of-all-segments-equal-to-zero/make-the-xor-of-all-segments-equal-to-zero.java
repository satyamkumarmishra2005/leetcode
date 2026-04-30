import java.util.*;

class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int MAXX = 1024; // since nums[i] < 2^10

        int[] dp = new int[MAXX];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < k; i++) {

            Map<Integer, Integer> freq = new HashMap<>();
            int size = 0;

            // build group
            for (int j = i; j < n; j += k) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
                size++;
            }

            int[] newDp = new int[MAXX];
            Arrays.fill(newDp, Integer.MAX_VALUE);

            int minDp = Integer.MAX_VALUE;
            for (int val : dp) minDp = Math.min(minDp, val);

            // fallback: change all
            Arrays.fill(newDp, minDp + size);

            // try all values in this group
            for (int x = 0; x < MAXX; x++) {
                if (dp[x] == Integer.MAX_VALUE) continue;

                for (int v : freq.keySet()) {
                    int cost = size - freq.get(v);
                    newDp[x ^ v] = Math.min(newDp[x ^ v], dp[x] + cost);
                }
            }

            dp = newDp;
        }

        return dp[0];
    }
}