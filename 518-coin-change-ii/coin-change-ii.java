class Solution {
    public int change(int amount, int[] coins) {

     int n = coins.length;

     int[][] dp = new int[n][amount+1];


     for(int[]row: dp){
        Arrays.fill(row,-1);
     }


     return solve(amount, coins, dp , n-1);
        
    }


    public int solve(int amount , int[]coins , int[][]dp , int indx){

        if(amount<0){
            return 0;
        }

        if(amount==0){
            return 1;
        }

        if(indx==0){

            if(amount%coins[0]==0){
                return 1;
            }

            return 0;
        }

       


        if(dp[indx][amount]!=-1){
            return dp[indx][amount];
        }

        int notpick = solve(amount, coins, dp , indx-1);

        int pick =0;

        if(coins[indx]<=amount){
            pick =solve(amount-coins[indx], coins, dp , indx);
        }

        return dp[indx][amount] = pick + notpick;
    }
}