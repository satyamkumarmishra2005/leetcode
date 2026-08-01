class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n][2];

        for(int[]row: dp){
            Arrays.fill(row,-1);
        }

        return solve(prices, 0, dp, 1, n);
        
    }

    public int solve(int[]prices, int indx , int[][]dp, int buy, int n){

        if(indx==n){
            return 0;
        }

        if(dp[indx][buy]!=-1){
            return dp[indx][buy];

        }

        int profit;

        if(buy==1){

            profit = Math.max( 0 + solve(prices, indx+1,dp,1,n) // skip buy
            , -prices[indx] + solve(prices,indx+1,dp,0,n)); // buy

        }

        else{

            profit = Math.max(0+ solve(prices, indx+1, dp ,0, n), // skip sell
            
            prices[indx]+ solve(prices, indx+1, dp ,1,n)); // sell 
        }


        dp[indx][buy] = profit;


        return profit;

    }
}