class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;
        int totSum = 0;
        for (int num : arr) {
            totSum += num;
        }

        // Checking for edge cases
        if (totSum - target < 0)
            return 0; // Not possible to achieve the target sum
        if ((totSum - target) % 2 == 1)
            return 0; // The difference between the total sum and target sum must be even

        int s2 = (totSum - target) / 2; // Calculate the required sum for each subset

        int[][] dp = new int[n][s2 + 1]; // Initialize DP table
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countPartitionsUtil(n - 1, s2, arr, dp); // Call the helper function
    }

    public static int countPartitionsUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base cases
        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2; // Two ways to partition: include or exclude the element
            if (target == 0 || target == arr[0])
                return 1; // One way to partition: include or exclude the element
            return 0; // No way to partition
        }

        // If the result for this index and target sum is already calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target];

        // Calculate the number of ways without taking the current element
        int notTaken = countPartitionsUtil(ind - 1, target, arr, dp);

        // Calculate the number of ways by taking the current element
        int taken = 0;
        if (arr[ind] <= target)
            taken = countPartitionsUtil(ind - 1, target - arr[ind], arr, dp);

        // Store the sum of ways in the DP array and return it
        dp[ind][target] = notTaken + taken;
        return dp[ind][target];
    }


}