class Solution {
    public int maxSubArray(int[] nums) {

        int bestending= nums[0]; // because at zero index the best ending can be itself 
        int ans = nums[0];

        int n = nums.length;

        

        for(int i = 1; i< n ; i++){

            int v1 = bestending + nums[i];
            int v2 = nums[i];

            bestending = Math.max(v1,v2);

            ans = Math.max(ans , bestending);

        }
          return ans;

        
    }
}