class Solution {
    public int uniquePaths(int m, int n) {
        int dp [] [] = new int [m][n];

        for(int [] rows : dp){
            Arrays.fill(rows , -1);
        }

        return countpath(m-1 , n-1 , dp);
    }

    static int countpath(int i , int j , int [][] dp){
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if(i == 0 && j==0){
            return 1;
        }

        // If we go out of bounds, there's no way to reach the cell.

        if(i< 0 || j<0){
            return 0;
        }
         // If the value for this cell is already computed, return it.
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        // Calculate the number of ways by moving up and moving left.
        int up = countpath(i-1 , j , dp);
        int left = countpath(i , j-1 , dp);

        return dp[i][j] = up + left;
    }
}