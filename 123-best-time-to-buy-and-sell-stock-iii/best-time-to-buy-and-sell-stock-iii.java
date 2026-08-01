class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;

        int[][][]dp = new int[n+1][2][3];

        for(int indx=n-1; indx>=0; indx--){
            for(int buy=0; buy<2; buy++){
                for(int cap=1; cap<=2; cap++){

                    if(buy==1){
                        dp[indx][buy][cap] = Math.max(

                            0 + dp[indx+1][1][cap] ,

                            -prices[indx] + dp[indx+1][0][cap]);
                        
                    }

                    else{

                        dp[indx][buy][cap] = Math.max(

                            0+ dp[indx+1][0][cap]  ,

                            prices[indx] + dp[indx+1][1][cap-1]
                        );
                    }
                }
            }
        }


        return dp[0][1][2];  // Final result: start at index 0, can buy, with 2 transactions left


    }
}