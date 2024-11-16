class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum = 0;

    for(int i =0 ; i< n ; i++){

    
     totalsum += nums[i];
    }

    if(totalsum%2==1){
        return false;
    }
    else{
        int k = totalsum/2;

        int [][] dp = new int[n][k+1];

        for(int [] rows : dp ){
            Arrays.fill(rows , -1);
        }

        return subsetpartition(n-1 , k , nums , dp);
    }
}


static boolean subsetpartition(int index , int target , int [] nums , int[][] dp){
    if(target==0){
        return true;
    }

    if(index==0){
        return nums[0] == target;
    }

    if(dp[index][target] != -1){
        return dp[index][target] == 0 ? false : true;
    }
   boolean notTaken = subsetpartition(index-1 , target , nums , dp);
     boolean taken = false;
        if (nums[index] <= target)
            taken = subsetpartition(index - 1, target - nums[index], nums, dp);

        // Memoize the result and return true if either choice results in a valid subset
        dp[index][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }



}
