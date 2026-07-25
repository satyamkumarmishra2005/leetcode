class Solution {
    public int coinChange(int[] coins, int amount) {

        int n= coins.length;

        int[][] dp = new int[n][amount+1];

        for(int[]row: dp){
            Arrays.fill(row,-1);
        }

        int ans = solve(coins, amount , n-1, dp,  n);

     // if answer is not found return -1;
        return ans >= (int) Math.pow(10, 9)?-1:ans;
        
    }


    public int solve(int[]coins , int amount , int indx , int[][]dp, int n){

        if(amount==0){
            return 0;
        }

        if(indx<0 || amount<0){
            return (int) Math.pow(10, 9);
        }


        if(dp[indx][amount]!=-1){
            return dp[indx][amount];
        }

        int nottake = solve(coins, amount , indx-1, dp, n);

             
             
int take = (int) Math.pow(10, 9);

  if(coins[indx]<=amount){
   take= 1+solve(coins,amount-coins[indx],indx,dp,n);
     }


   return dp[indx][amount] = Math.min(take, nottake);
    
    }
}