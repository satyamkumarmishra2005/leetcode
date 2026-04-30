import java.util.*;

class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;

        int[] validRowMask = new int[m];

        // Step 1: Build valid masks for each row
        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    mask |= (1 << j);
                }
            }
            validRowMask[i] = mask;
        }

        // dp[row][mask]
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int i = 0; i < m; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();

            for (int mask = 0; mask < (1 << n); mask++) {

                // condition 1: valid seats only
                if ((mask & validRowMask[i]) != mask) continue;

                // condition 2: no adjacent students
                if ((mask & (mask << 1)) != 0) continue;

                int students = Integer.bitCount(mask);

                for (int prev : dp.keySet()) {

                    // condition 3: no diagonal cheating
                    if ((mask & (prev << 1)) != 0) continue;
                    if ((mask & (prev >> 1)) != 0) continue;

                    newDp.put(mask,
                        Math.max(newDp.getOrDefault(mask, 0),
                                 dp.get(prev) + students));
                }
            }

            dp = newDp;
        }

        int res = 0;
        for (int val : dp.values()) {
            res = Math.max(res, val);
        }

        return res;
    }
}