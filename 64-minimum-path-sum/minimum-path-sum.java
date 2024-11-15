class Solution {
   // public int minPathSum(int[][] grid) {
        // Memoaization

//     Time Complexity: O(N*M)

// Reason: At max, there will be N*M calls of recursion.

// Space Complexity: O((M-1)+(N-1)) + O(N*M)

// Reason: We are using a recursion stack space: O((M-1)+(N-1)), here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.
    //     int m = grid.length;
    //     int n = grid[0].length;

    //     int [][] dp = new int[m][n];

    //     for(int [] rows : dp){
    //         Arrays.fill(rows,-1);
    //     }

    //     return pathsumMin(m-1 , n-1 , grid , dp);
    // }

    // static int pathsumMin(int i , int j , int [][] grid , int [][] dp){
    //     if(i==0 && j==0){
    //         return grid[0][0];
    //     }

    //     if(i<0 || j< 0){
    //         return (int) Math.pow(10, 9); 
    //     }

    //     if (dp[i][j] != -1)
    //         return dp[i][j]; 

    //     int up = grid[i][j] + pathsumMin(i-1 , j , grid , dp);
    //     int left = grid[i][j] + pathsumMin(i,j-1 , grid , dp);
        
    //     return dp[i][j] = Math.min(up,left);
    // }


    // Tabulation
     public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                // Starting cell
                dp[i][j] = grid[i][j];
            } else {
                int up = (i > 0) ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? dp[i][j - 1] : Integer.MAX_VALUE;

                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
    }

    return dp[m - 1][n - 1];
}





}