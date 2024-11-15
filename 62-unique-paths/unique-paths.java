class Solution {

    // Memoaization 
    // Tc = O(M*N)
   //Space Complexity: O((N-1)+(M-1)) + O(M*N)
//Reason: We are using a recursion stack space: O((N-1)+(M-1)), here (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    // public int uniquePaths(int m, int n) {
    //     int dp [] [] = new int [m][n];

    //     for(int [] rows : dp){
    //         Arrays.fill(rows , -1);
    //     }

    //     return countpath(m-1 , n-1 , dp);
    // }

    // static int countpath(int i , int j , int [][] dp){
    //     // If we reach the starting cell (0, 0), there's one way to reach it.
    //     if(i == 0 && j==0){
    //         return 1;
    //     }

    //     // If we go out of bounds, there's no way to reach the cell.

    //     if(i< 0 || j<0){
    //         return 0;
    //     }
    //      // If the value for this cell is already computed, return it.
    //     if(dp[i][j]!= -1){
    //         return dp[i][j];
    //     }
    //     // Calculate the number of ways by moving up and moving left.
    //     int up = countpath(i-1 , j , dp);
    //     int left = countpath(i , j-1 , dp);

    //     return dp[i][j] = up + left;
    // }

    

     // Tabulation


    // Time Complexity: O(M*N)

    //Reason: There are two nested loops

    //Space Complexity: O(M*N)

    //Reason: We are using an external array of size ‘M*N’’.
     
      public int uniquePaths(int m, int n) {

        int dp[][] = new int [m][n];

        for(int i =0 ; i< m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(i== 0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }

                int up =0;
                int left = 0;

                if(i> 0){
                    up = dp[i-1][j];

                }

                if(j>0){
                    left = dp[i][j-1];
                }

                dp[i][j] = up + left;
            }
        }
    
    return dp[m-1][n-1];
    

}

}