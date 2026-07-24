class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;

        int n = nums.length;

        for(int i=0; i<n ; i++){
            sum = sum + nums[i];
        }

        if(sum%2==1){
            return false;
        }
        else{

            int k = sum/2;

            int[][] dp = new int[n][k+1];


            for(int[] rows: dp){
                Arrays.fill(rows,-1);
            }


            return solve(nums, dp , n-1, k);
        
        }
    }

        public boolean solve(int[]nums , int[][]dp , int indx , int target){

            if(target==0){
                return true;
            }

            if(indx==0){
                return nums[0]==target;
            }

            if(dp[indx][target]!=-1){
                return dp[indx][target]==1;
            }

            boolean nottaken = solve(nums, dp, indx-1, target);

            boolean taken = false;

            if(nums[indx]<= target){
                taken = solve(nums, dp , indx-1, target-nums[indx]);
            }

            dp[indx][target] = (nottaken || taken)?1:0;


            return nottaken || taken;
        }
    }
