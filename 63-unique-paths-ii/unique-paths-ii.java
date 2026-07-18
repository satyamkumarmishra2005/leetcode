class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;

        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];


        for(int [] row : dp){
            Arrays.fill(row , -1);
        }

        return solve(obstacleGrid, dp , m-1 , n-1);
        
    }

    public int solve (int[][] obstacleGrid , int[][]dp , int i , int j){

        if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
            return 0;
        }

        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up = solve(obstacleGrid, dp , i-1, j);

        int left = solve(obstacleGrid , dp , i, j-1);

        return dp[i][j] = up + left;
    }
}