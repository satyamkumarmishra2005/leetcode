class Solution {
    public int maxSubArray(int[] nums) {
        // Optimized (Kadane's Algorithm)
        

        int maxi = Integer.MIN_VALUE;
        int sum =0;
        int n = nums.length;

        for(int i =0 ; i< n ; i++){
         sum = sum+ nums[i];

         if(sum> maxi){
            maxi = sum;
         }

         if ( sum < 0){
            sum =0;
         }
        }
        return maxi;
    }
}