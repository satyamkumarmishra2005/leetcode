
class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        Arrays.sort(cuts);

        // Create new array with boundaries
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        int[][] dp = new int[m + 2][m + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, m, arr, dp);
    }

    public int solve(int i, int j, int[] cuts, int[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int indx = i; indx <= j; indx++) {

            int cost = cuts[j + 1] - cuts[i - 1]
                    + solve(i, indx - 1, cuts, dp)
                    + solve(indx + 1, j, cuts, dp);

            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }
}
