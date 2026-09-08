class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentsum = nums[0];


        for(int i=1 ; i<nums.length ; i++){
            currentsum = Math.max(nums[i], currentsum+nums[i]);
            maxsum = Math.max(maxsum, currentsum);
        }
        return maxsum;
    }
}