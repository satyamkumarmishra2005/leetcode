class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currmax = nums[0];
        int currmin = nums[0];

        int maxsum = Math.abs(nums[0]); // we are not taking maxsum = nums[0] because if the first elemnt is itself negative then it gedt returned 
        // testcase  
        //Editorial Input nums = [-1] Use Testcase Output -1 Expected 1

        for(int i= 1 ; i< nums.length ; i++){
            currmax = Math.max(currmax + nums[i], nums[i]);
            currmin = Math.min(currmin+ nums[i], nums[i]);

            maxsum = Math.max(maxsum , Math.max(currmax, -(currmin)));
        }

        return maxsum;
        

    }
}