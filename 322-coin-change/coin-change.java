import java.util.Arrays;

class Solution {
    static int minimumcoinsreq(int[] coins, int indx, int[][] dp, int amount) {
        // Base cases
        if (amount == 0) return 0; // No coins needed if amount is 0
        if (indx < 0 || amount < 0) return (int) Math.pow(10, 9); // Unreachable case

        // Memoization check
        if (dp[indx][amount] != -1) return dp[indx][amount];

        // Not taken: Skip the current coin
        int nottaken = minimumcoinsreq(coins, indx - 1, dp, amount);

        // Taken: Include the current coin if possible
        int taken = (int) Math.pow(10, 9);
        if (coins[indx] <= amount) {
            taken = 1 + minimumcoinsreq(coins, indx, dp, amount - coins[indx]);
        }

        // Store the result in the DP table
        return dp[indx][amount] = Math.min(nottaken, taken);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Initialize DP table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = minimumcoinsreq(coins, n - 1, dp, amount);

        // If no solution found, return -1
        return ans >= (int) Math.pow(10, 9) ? -1 : ans;
    }
}
