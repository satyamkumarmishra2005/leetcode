class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int maxsum = nums[0];
        int minsum = nums[0];

        int currmax = 0;
        int currmin = 0;

        int totalsum = 0;

        for(int num : nums){

            currmax = Math.max(currmax+ num , num);
            currmin = Math.min(currmin + num , num);

            maxsum= Math.max(currmax, maxsum);
            minsum = Math.min(currmin,minsum);


            totalsum = totalsum + num;

        }

        if(maxsum>0){
            return Math.max(maxsum , totalsum-minsum);
        }

       return  maxsum;
        
    }
}