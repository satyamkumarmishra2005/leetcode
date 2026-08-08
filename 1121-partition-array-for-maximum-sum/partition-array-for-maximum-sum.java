class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(arr, k, 0, dp);
    }

    public int solve(int[] arr, int k, int i, int[] dp) {

        int n = arr.length;

        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int maxSum = 0;
        int maxElement = 0;

        for (int j = 1; j <= k && i + j <= n; j++) {

            maxElement = Math.max(maxElement, arr[i + j - 1]);

            int currentSum =
                    maxElement * j
                    + solve(arr, k, i + j, dp);

            maxSum = Math.max(maxSum, currentSum);
        }

        return dp[i] = maxSum;
    }
}