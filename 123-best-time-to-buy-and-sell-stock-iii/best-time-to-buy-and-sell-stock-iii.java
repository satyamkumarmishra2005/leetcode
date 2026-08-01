class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

          // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(prices,n, 1, 2,dp, 0);
        
    }

    public int solve(int[]prices, int n , int buy , int cap, int[][][]dp, int indx){

        if(cap==0){
            return 0;
        }

        if(indx==n){
            return 0;
        }

        if(dp[indx][buy][cap]!=-1){
            return dp[indx][buy][cap];
        }

        int profit;


        if(buy==1){ //  buy

            profit = Math.max( 0 + solve(prices, n, 1,cap,dp,indx+1) // skip buy

            , -prices[indx] + solve(prices, n,0, cap, dp ,indx+1)); // buy

        }


        else{ // sell

        profit = Math.max( 0+solve(prices,n,0,cap,dp,indx+1) // skip sell

        , prices[indx]+ solve(prices,n,1,cap-1,dp,indx+1)); // sell

        }


    dp[indx][buy][cap] = profit;

    return profit;


    }
}