class Solution {
    // Memoaization



    // In this question instead of going from n-1 , m-1 to 0,0
    // we are going from 0,0 to last col because our starting point is fixed but not our ending point 
    // our ending point lies in the last column

    // public int minimumTotal(List<List<Integer>> triangle) {
    //      // Create a 2D array to store computed results, initialize with -1
    //     int n = triangle.size();
    //     int [][] dp = new int [n][n];
      
    //   for(int [] rows : dp ){
    //     Arrays.fill(rows,-1);
    //   }
    //    // Call the  function to find the minimum path sum starting from the top
    //   return minimumpathsum(0,0,n,dp , triangle);
    // }

    // static int minimumpathsum(int i , int j ,int n, int[][] dp , List<List<Integer>> triangle){
    //       // Check if the result for the current position (i, j) is already calculated
    //     if(dp[i][j]!= -1){
    //         return dp[i][j];
    //     }

    //     if(i==n-1){ // if we are at the last row return the columns
    //      return triangle.get(i).get(j);

    //     }

    //       // Calculate the minimum path sum by recursively considering two possible paths: down and diagonal

    //     int down = triangle.get(i).get(j) + minimumpathsum(i+1 , j ,n , dp , triangle);
    //     int diagonal = triangle.get(i).get(j) + minimumpathsum(i+1 , j+1 , n ,dp , triangle);

    //      // Store the result in the dp array and return the minimum of the two paths
    //     return dp[i][j] = Math.min(down , diagonal);
    // }


    // Tabulation

   public int minimumTotal(List<List<Integer>> triangle){
    int n = triangle.size();

    int [][] dp = new int [n][n];

    for(int j =0 ; j < n ; j++){
        dp[n-1][j] = triangle.get(n-1).get(j);
    };
   
   // Starting from the second to last row, calculate the minimum path sum for each element
    for(int i = n-2 ; i>=0 ; i--){
        for(int j = i ; j>=0 ; j--){

    int down = triangle.get(i).get(j) + dp[i+1][j];
    int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];

    dp[i][j] = Math.min(down , diagonal);

        }
    }

    return dp[0][0];

   }

}