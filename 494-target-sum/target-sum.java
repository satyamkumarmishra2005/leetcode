class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int totalsum =0;

        for(int num: nums){
         totalsum = totalsum + num;
        }

        if ((totalsum - target) < 0 || (totalsum - target) % 2 != 0)
            return 0;


        int subsetsum = (totalsum- target)/2;

         int[][] dp = new int[n][subsetsum+1];

         for(int[]row: dp){
            Arrays.fill(row,-1);
        }




        
    return solve(nums,subsetsum,n-1, dp);
    }

    public int solve(int[]nums, int target, int indx, int[][]dp){

        if(indx==0){

            if(target==0 && nums[0]==0){
                return 2;
            }

            if(target==0 || target==nums[0]){
                return 1;
            }

            return 0;
        }


        if(dp[indx][target]!=-1){
            return dp[indx][target];
        }

        int notpick = solve(nums, target, indx-1,dp);

        int pick =0;

        if(nums[indx]<= target){
            pick = solve(nums, target-nums[indx], indx-1,dp);
        }


        return dp[indx][target] = pick+ notpick;
    }
}