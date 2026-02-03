class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int i = 0;
        int j =0;

        int n = nums.length;

        int min = Integer.MAX_VALUE;

        int sum = 0;

        while(j< n){
         sum = sum + nums[j];

         if(sum < target){
            j++;
         }

         else if (sum >= target){

            while(sum>= target){
            sum = sum - nums[i];

            min = Math.min(min , j-i+1);

            i++;

         }

         j++;
        }
        }
     if(min == Integer.MAX_VALUE){
        return 0;
     }

     return min;
        
    }
}