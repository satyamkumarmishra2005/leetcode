class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int maxF = 0;

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            maxF = Math.max(maxF, map.get(x));
        }

        if (maxF > k)
            return -1;

        int n = nums.length;
        int grpSi = n / k;
        int total = (1 << n);
        Map<Integer, Integer> costM = new HashMap<>(); // (mask, cost)

        for (int mask = 0; mask < total; mask++) {
            if (Integer.bitCount(mask) != grpSi)
                continue;

            Set<Integer> set = new HashSet<>();
            boolean canTake = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if(set.contains(nums[i])) canTake = false;
                    set.add(nums[i]);
                }
            }

            if(!canTake) continue;

            int msb = -1, lsb = -1;

            for (int j = n - 1; j >= 0; j--) {
                if ((mask & (1 << j)) != 0) {
                    msb = j;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    lsb = j;
                    break;
                }
            }

            if(lsb == -1 || msb == -1) continue;

            costM.put(mask, nums[msb] - nums[lsb]);

        }

        int[] dp = new int[total];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int mask = 0; mask < total; mask++) {
            if(dp[mask] == Integer.MAX_VALUE) continue;

            if(Integer.bitCount(mask) % grpSi != 0) continue;

            for(int subMask: costM.keySet()) {
                if((mask & subMask) != 0) continue;

                int nMask = (mask | subMask);
                dp[nMask] = Math.min(dp[nMask], dp[mask] + costM.get(subMask));
            }
        }

        return dp[total-1] == Integer.MAX_VALUE ? -1 : dp[total-1];
    }
}