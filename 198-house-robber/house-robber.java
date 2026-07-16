class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp,-1);


        return solve(n-1, nums, dp);
        
    }

    public int solve(int indx , int[]nums , int[]dp){

        if(indx<0){
            return 0;
        }

        if(indx==0){
            return nums[indx];
        }

        if(dp[indx]!= -1){
            return dp[indx];
        }

        int pick = nums[indx] + solve(indx-2, nums , dp);

        int notpick = solve(indx-1, nums, dp);


        return dp[indx] = Math.max(pick, notpick);
    }
}