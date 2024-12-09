class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n][2][3];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<2 ; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return solve(prices , 0,1,0,dp,n);
    }

    static int solve(int [] prices , int index , int buy , int cap , int[][][] dp , int n){
        if(index==n){
            return 0;
        }
        if(cap == 2){
            return 0;
        }

        if(dp[index][buy][cap]!=-1){
            return dp[index][buy][cap];
        }
      int profit = 0;
        if(buy == 1){ // we can buy the stock
        // buy 
        int op1 = - prices[index] + solve(prices , index+1 , 0 , cap , dp , n);
        // skip
        int op2 = solve(prices , index+1 , 1 , cap , dp , n);
        profit = Math.max(op1 , op2);
        }
      else{  //sell the stock
    // sell
    int op1 = prices[index] + solve(prices , index+1 , 1 , cap+1 , dp , n);
    // skip
    int op2 = solve(prices , index+1 , 0 , cap ,dp , n);

    profit = Math.max(op1 , op2);
      }
    return   dp[index][buy][cap] = profit;
    }
}