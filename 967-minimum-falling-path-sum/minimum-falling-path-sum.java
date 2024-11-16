class Solution {
    //public int minFallingPathSum(int[][] matrix) {

        // Memoaziation
    //     int n = matrix.length;
    //     int m = matrix[0].length;

    //     int [][] dp = new int[n][m];

    //     for(int[] rows : dp){
    //         Arrays.fill(rows,-1);
    //     }

    //     int mini = Integer.MAX_VALUE;
    //     for(int j =0 ; j< m ; j++){
    //     int ans = minsumofpaths(n-1 , j , m , dp , matrix);
    //     mini = Math.min(mini , ans);
    //     }

    //     return mini;
        
    // }


    // static int minsumofpaths(int i , int j , int m , int[][] dp , int [][] matrix){
    //     if(j<0 || j>=m){
    //         return (int) Math.pow(10,9);
    //     }
      
    //   if(i==0){
    //     return matrix[0][j];
    //   }

    //   if(dp[i][j]!=-1){
    //     return dp[i][j];
    //   }

    //   int up = matrix[i][j]+ minsumofpaths(i-1 , j , m , dp , matrix);

    //   int rightdiagonal = matrix[i][j] + minsumofpaths(i-1 , j+1 , m , dp , matrix);

    //   int leftdiagonal = matrix[i][j] + minsumofpaths(i-1 , j-1 , m , dp , matrix);


    //   return dp[i][j] = Math.min(up ,Math.min(leftdiagonal , rightdiagonal));
    // }

    // Tabulation

     public int minFallingPathSum(int[][] matrix) {

         int n = matrix.length;
        int m = matrix[0].length;

        int [][] dp = new int [n][m];

         // Initializing the first row - base condition
         for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

         // Calculate the minimum path sum for each cell in the matrix

        for(int i = 1; i< n ; i++){
            for(int j = 0 ; j< m ; j++){

       
        int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(10, 9);
                }

                // Store the minimum of the three paths in dp
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        // Find the minimum value in the last row of dp
        int mini = Integer.MAX_VALUE;
     for(int j = 0 ; j<m ; j++){
      mini =  Math.min(mini , dp[n-1][j]);

     }
     return mini;
     }
}