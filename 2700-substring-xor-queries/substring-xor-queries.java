import java.util.*;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {

        Map<Integer, int[]> map = new HashMap<>();
        int n = s.length();

        // Precompute all substring values (length ≤ 30)
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '0') {
                // special case: "0"
                map.putIfAbsent(0, new int[]{i, i});
                continue;
            }

            int val = 0;

            for (int j = i; j < Math.min(i + 30, n); j++) {
                val = (val << 1) + (s.charAt(j) - '0');

                map.putIfAbsent(val, new int[]{i, j});
            }
        }

        // Answer queries
        int[][] ans = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            int target = queries[i][0] ^ queries[i][1];

            if (map.containsKey(target)) {
                ans[i] = map.get(target);
            } else {
                ans[i] = new int[]{-1, -1};
            }
        }

        return ans;
    }
}