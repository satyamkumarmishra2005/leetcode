class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n][2];

        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }

        return solve(0 ,1, prices , dp , n );

    }

    static int solve(int index , int buy , int[] prices , int[][]dp , int n){
        if(index>=n){
            return 0;
        }

        if(dp[index][buy]!= -1){
            return dp[index][buy];
        }

        int profit = 0;

        if(buy==1){ // buy 
        int op1 = - prices[index] + solve(index+1 , 0 , prices , dp , n); // buy
        int op2 = solve(index+1 , 1 , prices , dp , n); // skip

        profit = Math.max(op1 , op2);
     
        }

        else{ // sell
            int op1 = prices[index] + solve(index+2 , 1 , prices , dp , n );
            int op2 = solve(index+1 , 0 , prices , dp , n);// skip

            profit = Math.max(op1 , op2);
        }

        return dp[index][buy] = profit;
    }
}