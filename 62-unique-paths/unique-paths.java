class Solution {
    public int uniquePaths(int m, int n) {
        

        int [][] dp = new int [m][n];

        for(int [] row : dp){
            Arrays.fill(row,-1);
        }


        return solve(dp, m-1, n-1);
    }


    public int solve(int[][] dp , int row , int col){

        if(row==0 && col==0){
            return 1;
        }

        if(row<0 || col<0){
            return 0;
        }

        if(dp[row][col]!=-1){
            return dp[row][col];
        }

        int up = solve(dp, row-1, col);

        int left = solve(dp, row, col-1);


        return dp[row][col] = up + left;
    }
}