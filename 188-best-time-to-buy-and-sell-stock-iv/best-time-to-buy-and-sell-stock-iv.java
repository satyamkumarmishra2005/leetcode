class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n][2][k+1];

        for(int i =0; i< n ; i++){
            for(int j = 0 ; j<2 ; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
     

     return solve(prices, dp , 0 , k, n,1);

        
    }


    public int solve(int[]prices, int[][][]dp , int indx , int k , int n, int buy){

        if(k==0 || indx==n){
            return 0;
        }

    if(dp[indx][buy][k]!=-1){
        return dp[indx][buy][k];
    }

    int profit;

    if(buy==1){
        profit = Math.max(-prices[indx] + solve(prices,dp, indx+1, k, n , 0) , // buy

        0 + solve(prices, dp , indx+1, k,n, 1));  // skip buy
    }

    else{ // sell
     
     profit =  Math.max(prices[indx] + solve(prices,dp,indx+1,k-1,n,1) ,  // sell

      0+ solve(prices,dp,indx+1, k , n ,0)); // skip sell
    }


    return dp[indx][buy][k] = profit;

    }
}