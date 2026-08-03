class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];


        for(int indx = n-1; indx>=0; indx--){

            for(int buy=0; buy<=1; buy++){

                for(int cap= 1 ; cap<=k ; cap++){


                    if(buy==1){

                        dp[indx][buy][cap] = Math.max(-prices[indx] + dp[indx+1][0][cap],
                        
                        0 + dp[indx+1][1][cap]);
                    }

                    else{

                        dp[indx][buy][cap] = Math.max(prices[indx]+ dp[indx+1][1][cap-1],
                        
                        0+ dp[indx+1][0][cap]);
                    }
                }
            }
        }


        return dp[0][1][k];
        
    }
}