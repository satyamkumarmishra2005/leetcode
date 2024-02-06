class Solution {
    public int maxSubArray(int[] nums) {
     int maxsum = nums[0] , max = nums[0];
   for(int i = 1 ; i<nums.length; i++){
 if(maxsum<0){
     maxsum = 0;
 }
maxsum = maxsum + nums[i];
 max = Math.max(maxsum,max);
   }
   return max;
    }
}