class Solution {
    public int minFallingPathSum(int[][] matrix) {
        

        int m = matrix.length;
        int n = matrix[0].length;

        int [][] dp = new int[m][n];

        for(int[] rows : dp){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        int mini = Integer.MAX_VALUE;

        for(int j =0; j< n ; j++){

            int ans = solve(matrix , m-1, j,n , dp );
            mini = Math.min(mini , ans);

        }

    return mini;
        
    }


    public int solve(int[][] matrix , int i , int  j , int n , int[][] dp){

        if(j<0 || j>= n){
            return (int) Math.pow(10,9);
        }

        if(i==0){
            return matrix[0][j];
        }

        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

        int up = matrix[i][j] + solve(matrix , i-1, j, n , dp);

        int ld = matrix[i][j] + solve(matrix, i-1,j-1,n,dp);

        int rd = matrix[i][j] + solve(matrix , i-1, j+1, n , dp);


        return dp[i][j] = Math.min(up , Math.min(ld,rd));
    }
}