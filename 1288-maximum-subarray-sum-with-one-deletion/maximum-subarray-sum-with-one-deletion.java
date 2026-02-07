class Solution {
    public int maximumSum(int[] nums) {

        int dp0 = nums[0];  // no deletion
        int dp1 = 0;        // one deletion
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            dp1 = Math.max(dp0, dp1 + nums[i]); // delete nums[i] OR extend deletion
            dp0 = Math.max(nums[i], dp0 + nums[i]);

            ans = Math.max(ans, Math.max(dp0, dp1));
        }

        return ans;
    }
}
