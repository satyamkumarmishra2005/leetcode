class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     // memoaization
    // int n = nums.length;
    //  int [][] dp = new int[n][n+1];

    //  for(int []rows :dp ){
    //     Arrays.fill(rows,-1);
    //  }

    //  return solve(nums , 0 , -1 , dp, n );
    // }

    // static int solve(int[] nums , int indx , int prev_indx , int[][] dp , int n){
    //     if(indx==n){
    //         return 0;
    //     }

    //     if(dp[indx][prev_indx+1]!= -1){
    //         return dp[indx][prev_indx+1];
    //     }

    //     int nottake = 0 + solve(nums, indx+1 , prev_indx , dp , n);
    //     int take = 0;
    //     if(prev_indx==-1 || nums[indx]> nums[prev_indx]){
    //         take = 1+ solve(nums , indx+1 , indx , dp , n);

    //     }

    //     dp[indx][prev_indx+1] = Math.max(nottake , take);
    //     return dp[indx][prev_indx+1];
    // }
    // Tabulation
     public int lengthOfLIS(int[] nums){
        int n = nums.length;
         int dp[][]=new int[n+1][n+1];
    
    for(int ind = n-1; ind>=0; ind --){
        for (int prev_index = ind-1; prev_index >=-1; prev_index --){
            
            int notTake = 0 + dp[ind+1][prev_index +1];
    
            int take = 0;
    
            if(prev_index == -1 || nums[ind] > nums[prev_index]){
                
                take = 1 + dp[ind+1][ind+1];
            }
    
            dp[ind][prev_index+1] = Math.max(notTake,take);
            
        }
    }
    
    return dp[0][0];

     }
}