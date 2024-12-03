class Solution {

    // Memoaization
    // public int change(int amount, int[] coins) {
    //     int n = coins.length;

    //     int[][] dp = new int[n][amount+1];

    //     for(int [] row : dp){
    //         Arrays.fill(row , -1);
    //     }
    //     return numberofways(n-1 , amount , coins , dp);
    // }

    // static int numberofways(int index , int amount , int [] coins , int[][] dp){
    //     if(index ==0){
    //         if(amount % coins[0] == 0){
    //             return 1;
    //         }

    //         else{
    //             return 0;
    //         }
    //     }


    //     if(dp[index][amount]!=-1){
    //         return dp[index][amount];
    //     }
    //     int nottaken = numberofways(index-1 , amount , coins , dp);
      
    //     int taken = 0;

    //     if(coins[index]<= amount){
    //         taken = numberofways(index , amount-coins[index], coins , dp);
    //     }

    //     return dp[index][amount] = nottaken + taken ;
    // }


    // Tabulation
    public int change(int amount, int[] coins){
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i = 0 ; i <= amount ; i++){
            if(i % coins[0]==0){
                dp[0][i] = 1;
            }
        }

           for(int index = 1 ; index < n ; index++){
            for(int target =0 ; target<= amount ; target++){

                int nottaken = dp[index-1][target];

                int taken = 0;
                if(coins[index]<= target){
                    taken = dp[index][target-coins[index]];
                }

                dp[index][target] = nottaken + taken ;
            }
           
        }

        return dp[n-1][amount];
    }

}