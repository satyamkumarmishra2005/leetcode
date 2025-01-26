class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxsum = nums[0];
        int minsum = nums[0];
        int currmax = 0;
        int currmin = 0;
        int totalsum = 0;

        for(int num : nums){
            currmax= Math.max(currmax + num , num);
            maxsum = Math.max(maxsum , currmax);
            currmin = Math.min(currmin + num , num);
            minsum = Math.min(minsum, currmin);
            totalsum+= num ;
            
        }

        if(maxsum > 0){
            return Math.max(maxsum , totalsum-minsum ); // cirrsum = totalsum- minsum;
        }
       return maxsum;
    }
}