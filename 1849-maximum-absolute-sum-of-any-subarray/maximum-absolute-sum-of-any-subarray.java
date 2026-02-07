class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currmax = nums[0];
        int currmin = nums[0];

        int maxsum = Math.abs(nums[0]);

        for(int i= 1 ; i< nums.length ; i++){
            currmax = Math.max(currmax + nums[i], nums[i]);
            currmin = Math.min(currmin+ nums[i], nums[i]);

            maxsum = Math.max(maxsum , Math.max(currmax, -(currmin)));
        }

        return maxsum;
        
    }
}