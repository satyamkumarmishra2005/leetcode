class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n+1];


        for(int []row: dp){
            Arrays.fill(row,-1);
        }


        return solve(nums, n , dp , 0, -1);
        
    }

    public int solve(int[]nums , int n , int[][]dp , int indx , int prev_indx){

        if(indx==n){
            return 0;
        }

        if(dp[indx][prev_indx+1]!=-1){

            return dp[indx][prev_indx+1];

        }

        
        int take =0;
        int nottake;

        if(prev_indx==-1 || nums[indx]> nums[prev_indx]){
             take = 1+ solve(nums, n , dp , indx+1, indx);
        }


         nottake = solve(nums, n , dp, indx+1, prev_indx);



     return  dp[indx][prev_indx+1] = Math.max(take,nottake);


    }
}