class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int [n][n];
      
      for(int [] rows : dp ){
        Arrays.fill(rows,-1);
      }

      return minimumpathsum(0,0,n,dp , triangle);
    }

    static int minimumpathsum(int i , int j ,int n, int[][] dp , List<List<Integer>> triangle){
        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        if(i==n-1){ // if we are at the last row return the columns
         return triangle.get(i).get(j);

        }

        int down = triangle.get(i).get(j) + minimumpathsum(i+1 , j ,n , dp , triangle);
        int diagonal = triangle.get(i).get(j) + minimumpathsum(i+1 , j+1 , n ,dp , triangle);
        return dp[i][j] = Math.min(down , diagonal);
    }
}